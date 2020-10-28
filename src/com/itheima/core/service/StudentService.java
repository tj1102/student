package com.itheima.core.service;


import com.itheima.common.utils.Page;
import com.itheima.core.po.Student;

/**
 * Service层处理分页数据
 * @param currentPage 当前页码
 * @param pageSize 每页多少条
 * @param username 查询条件
 * @return 封装后的带有分页的列表
 */

public interface StudentService {


	//根据id查询学生
	public Student findStudentById(Integer stu_id);
	//添加学生
	public void addStudent(Student student);
	//更新学生
	public void updateStudent(Student student);
	//删除学生
	public void deleteStudent(Integer stu_id);
	//分页
	public Page<Student> findStudentByName(Integer currentPage,
										   Integer pageSize, String stu_name);
	//根据学号查询学生
	public Student findStudentByNumber(Integer stu_number);

}
