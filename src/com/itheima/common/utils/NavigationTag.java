package com.itheima.common.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * 显示格式：首页 上一页 1 2 3 4 5下一页 尾页
 */
public class NavigationTag  extends TagSupport {

	//标签上下文
	private PageContext pageContext;

	//定义属性变量,并提供set和get方法
	private Integer currentPage;

	private Integer totalPage;

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext=pageContext;
	}



	@Override
	public int doStartTag() throws JspException {

		try {

			JspWriter out = pageContext.getOut();

			String pageStr = "<div class=\"col-md-12 text-right\"/><nav>"+
					"<ul class=\"pagination\">"+
					"<li><a href=\"#\" onclick=\"searchStudent(1)\">首页</a></li>"+
					"<li><a href=\"#\" onclick=\"searchStudent(" + (Integer.valueOf(currentPage) - 1) + ")\">上一页</a></li>"+
					"<li><a href=\"#\" onclick=\"searchStudent(" + (Integer.valueOf(currentPage) + 1) + ")\">下一页</a></li>"+
					"<li><a href=\"#\" onclick=\"searchStudent(" + totalPage + ")\">尾页</a></li>"+
					"</ul></nav></div>";

			out.write(pageStr);

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return super.doStartTag();
	}



	public Integer getCurrentPage()
	{
		return currentPage;
	}



	public void setCurrentPage(Integer currentPage)
	{
		this.currentPage = currentPage;
	}



	public Integer getTotalPage()
	{
		return totalPage;
	}



	public void setTotalPage(Integer totalPage)
	{
		this.totalPage = totalPage;
	}
}
