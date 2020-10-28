package com.itheima.core.service.impl;

import java.util.List;

import com.itheima.common.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.core.dao.StudentDao;
import com.itheima.core.po.Student;
import com.itheima.core.service.StudentService;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	//注入StudentDao
	@Autowired
	private StudentDao studentDao;
	//根据stu_id查询学生
	@Override
	public Student findStudentById(Integer stu_id) {
		// TODO Auto-generated method stub
		return this.studentDao.findStudentById(stu_id);
	}



	//	添加学生
	@Override
	public void addStudent(Student student) {
		this.studentDao.addStudent(student);

	}
	//更新学生
	@Override
	public void updateStudent(Student student) {

		this.studentDao.updateStudent(student);

	}
	//	删除学生
	@Override
	public void deleteStudent(Integer stu_id) {

		this.studentDao.deleteStudent(stu_id);
	}


	//分页
	@Override
	public Page<Student> findStudentByName(Integer currentPage,
										   Integer pageSize, String stu_name) {
		// 创建学生对象
		Student student = new Student();
		// 判断学生名称
		if(null != stu_name && !"".equals(stu_name)){
			student.setStu_name(stu_name);
		}

		// 当前请求页显示的第一条数据的索引
		student.setStart((currentPage-1) * pageSize) ;

		// 每页显示的条数
		student.setRows(pageSize);

		// 查询学生列表
		List<Student> students = studentDao.findStudentByName(student);

		// 查询学生列表总记录数
		Integer count = studentDao.findStudentByNameCount(student);

		// 创建Page返回对象
		Page<Student> result = new Page<Student>();
		result.setCurrentPage(currentPage);
		result.setPageList(students);
		result.setPageSize(pageSize);
		result.setTotalSize(count);

		return result;
	}

//根据学号查询

	@Override
	public Student findStudentByNumber(Integer stu_number) {
		// TODO Auto-generated method stub
		return this.studentDao.findStudentByNumber(stu_number);


	}











}
