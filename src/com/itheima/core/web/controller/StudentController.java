package com.itheima.core.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.itheima.common.utils.Page;
import com.itheima.core.po.Student;
import com.itheima.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	/**
	 * 打开学生信息页面
	 */
	@RequestMapping("student/toStudent")
	public String toStudent(){
		// 返回学生信息展示页面
		return "student";
	}
	/**
	 * 根据学生名称查询学生详情,局部刷新页面
	 */
	@RequestMapping("/student/studentQuery.action")
	@ResponseBody
	public ModelAndView findStudentByName(String stu_name, @RequestParam(defaultValue = "1") Integer currentPage,
										  @RequestParam(defaultValue = "5") Integer pageSize,HttpServletRequest request) {

		//查询数据库
		Page<Student> pageList =studentService.findStudentByName(currentPage, pageSize, stu_name);

		ModelAndView mv = new ModelAndView();

		//将查询结果抛到后台
		mv.addObject("page", pageList);

		mv.setViewName("studentList");


		// 返回学生信息展示页面
		return mv;
	}


	/*
	 * 根据学号查询学生详情
	 *
	 */
	@RequestMapping("/student/findStudentByNumber.action")
	public String findStudentByNumber(Integer stu_number,Model model){
		Student student = studentService.findStudentByNumber(stu_number);
		model.addAttribute("student", student);
		//返回学生信息页面
		return "student";

	}


	/*
	 * 根据id查询学生详情
	 *
	 */
	@RequestMapping("/student/findStudentById.action")
	public String findStudentById(Integer stu_id,Model model){
		Student student = studentService.findStudentById(stu_id);
		model.addAttribute("student", student);
		//返回学生信息页面
		return "student";

	}

	/*
	 * 添加学生
	 *
	 */
	@RequestMapping("/student/addStudent.action")
	public String addStudent(Student student,Model model){
		//将所有数据封装到集合中去

		studentService.addStudent(student);
		model.addAttribute("student", student);
		return "student";


	}

	/*
	 * 更新学生
	 *
	 */
	@RequestMapping("/student/updateStudent.action")
	public String updateStudent(Student student,Model model){
		studentService.updateStudent(student);
		model.addAttribute("student", student);
		//返回学生信息页面展示
		return "student";
	}
	/*
	 * 删除学生
	 *
	 */
	@RequestMapping("/student/deleteStudent.action")
	public String deleteStudent(Integer stu_id,Model model){
		studentService.deleteStudent(stu_id);
		return "student";
	}



}
