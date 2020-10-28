package com.itheima.core.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.common.utils.ValidateCode;
import com.itheima.core.po.User;
import com.itheima.core.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	//依赖注入
	/**
	 *
	 */
	@Autowired
	private UserService userService;
	/**
	 * 用户登录
	 */
	@RequestMapping(value="login.action",method=RequestMethod.POST)
	public String login(String username,String password,String yzm,Model model,HttpSession session){
		//通过名称和密码查询客户
		User user = userService.findUser(username, password);
		String attribute = (String) session.getAttribute("randomString");//验证码
		if(user!=null){
			//将用户对象添加到Session
			if(!yzm.equalsIgnoreCase(attribute)){
				session.setAttribute("msg","验证码错误，请重新输入");
				return  "login";

			}else{
				session.setAttribute("USER_SESSION",user);
				//跳转到主页面
				return "student";


			}

		}
		model.addAttribute("msg","学生或者密码错误");

		//返回登录页面
		return "login";


	}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout.action")
	public String logout(HttpSession session)
	{
		// 清除Session
		session.invalidate();

		// 重定向到登录页面的跳转方法
		return "redirect:login.action";
	}
	/**
	 * 向用户登陆页面跳转
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String toLogin()
	{
		return "login";
	}

	/**
	 * 注册
	 */
	@RequestMapping(value="/user/register.action")
	public String registerUser(User user,Model model){
		//通过名称和密码查询学生
		userService.registerUser(user);
		model.addAttribute("user",user);
		//返回跳转页面
		return "userRegister";
	}
	/**
	 * 模拟其他类中跳转到用户	管理页面的方法
	 */
	@RequestMapping(value ="/toStudent.action")
	public String toStudent()
	{
		return "student";
	}


	/**
	 * 验证码
	 */


	@RequestMapping(value="/yzmImage.action" , method=RequestMethod.GET)
	public void yzmImage (HttpServletRequest request,HttpServletResponse response) throws Exception{
		ValidateCode code = new ValidateCode();
		response.setContentType("image/jpeg");
		String randomString = code.getRandomString();
		//将生成的验证放到会话里面，便于从会话中提取验证
		request.getSession(true).setAttribute("randomString", randomString);
		int width= 100;
		int height= 30;
		//获得验证码背景颜色
		Color color = code.getRandomColor();
		//获得验证码字体的颜色，是背景颜色的反色
		Color reverse = code.getReverseColor(color);
		//在内存中生成图片
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		//获得图片操作工具
		Graphics2D g = bi. createGraphics();
		//设置字体
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		//设置图片颜色
		g.setColor(color);//填充到背景矩形中
		g. fillRect(0, 0, width, height);
		//设置字体颜色
		g. setColor(reverse);
		//经对应的字符串画到图片里面
		g. drawString(randomString, 1,20);
		//随机生成背景图片.上的混淆点
		for (int i = 0, n = code.random.nextInt(100); i < n; i++)
			g. drawRect(code.random.nextInt(width),code.random.nextInt(height),1, 1);
		//转成JPEG格式
		ServletOutputStream out=response.getOutputStream();
		//将图片输出到浏览器
		ImageIO.write(bi, "jpeg", out);
		//清空缓存
		out. flush();


	}





	/**
	 * 执行文件上传
	 */
	@RequestMapping("/student/importFile.action")
	public String handleFormUpload(@RequestParam("name") String name,
								   @RequestParam("uploadStudentfile") List<MultipartFile> uploadfile,
								   HttpServletRequest request) {
		// 判断所上传文件是否存在
		if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
			// 循环输出上传的文件
			for (MultipartFile file : uploadfile) {
				// 获取上传文件的原始名称
				String originalFilename = file.getOriginalFilename();
				// 设置上传文件的保存地址目录
				String dirPath = request.getServletContext().getRealPath(
						"/upload/");
				File filePath = new File(dirPath);
				// 如果保存文件的地址不存在，就先创建目录
				if (!filePath.exists()) {
					filePath.mkdirs();
				}
				// 使用UUID重新命名上传的文件名称(上传人_uuid_原始文件名称)
				String newFilename = name + "_" + UUID.randomUUID() + "_"
						+ originalFilename;
				try {
					// 使用MultipartFile接口的方法完成文件上传到指定位置
					file.transferTo(new File(dirPath + newFilename));
					//查看图片的位置
					System.out.println(dirPath+newFilename);
				} catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
			}
			// 跳转到成功页面
				return "success";
		} else {
			return "error";
		}
	}
	/**
	 * 下载模板
	 */
	@RequestMapping("/student/template.action")
	@ResponseBody
	public ResponseEntity<byte[]> fileDownload(HttpServletRequest request)throws Exception
	{
		// 指定要下载的文件所在路径
		String path = request.getServletContext().getRealPath("/upload/");

		String filename = "1.png";

		// 创建该文件对象
		File file = new File(path + File.separator + filename);

		// 对文件名编码，防止中文文件乱码
		filename = this.getFilename(request, filename);

		// 设置响应头
		HttpHeaders headers = new HttpHeaders();

		// 通知浏览器以下载的方式打开文件
		headers.setContentDispositionFormData("attachment", filename);

		// 定义以流的形式下载返回文件数据
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		// 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.OK);
	}

	/**
	 * 根据浏览器的不同进行编码设置，返回编码后的文件名
	 */
	public String getFilename(HttpServletRequest request,
							  String filename) throws Exception {
		// IE不同版本User-Agent中出现的关键词
		String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};

		// 获取请求头代理信息
		String userAgent = request.getHeader("User-Agent");
		for (String keyWord : IEBrowserKeyWords)
		{
			if (userAgent.contains(keyWord))
			{
				//IE内核浏览器，统一为UTF-8编码显示
				return URLEncoder.encode(filename, "UTF-8");
			}
		}
		//火狐等其它浏览器统一为ISO-8859-1编码显示
		return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
	}


}
