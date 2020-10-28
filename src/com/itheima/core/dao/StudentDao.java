package com.itheima.core.dao;

import java.util.List;

import com.itheima.core.po.Student;

/**
 * Student接口文件
 * @author tianjie
 *
 */


public interface StudentDao {
	/**
	 * 根据用户姓名查询客户信息
	 */
	public List<Student> findStudentByName(Student student);


	/**
	 * 根据用户姓名查询所有的条数
	 * @param customer
	 * @return
	 */
	public int findStudentByNameCount(Student student);


	// 根据id查询学生信息
	public Student findStudentById(Integer stu_id);
	//添加学生
	public void addStudent(Student student);
	//更新学生
	public void updateStudent(Student student);
	//删除学生
	public void deleteStudent(Integer stu_id);
	//根据学号查询学生
	public Student findStudentByNumber(Integer stu_number);
	//根据名称进行模糊查询
	public Student findByName(Student student);
}
