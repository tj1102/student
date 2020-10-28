package com.itheima.core.po;
/**
 * 学生持久化类
 * @author tianjie
 *
 */
public class Student {
	private Integer stu_id;	//主键
	private String stu_name;//名称
	private String stu_jobs;//职业
	private String stu_phone;//电话
	private String stu_course;//课程
	private Integer stu_number;//学号
	private Integer start;            // 查询数据库起始行
	private Integer rows;             // 查询所取行数

	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getStu_id() {
		return stu_id;
	}
	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_jobs() {
		return stu_jobs;
	}
	public void setStu_jobs(String stu_jobs) {
		this.stu_jobs = stu_jobs;
	}
	public String getStu_phone() {
		return stu_phone;
	}
	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}
	public String getStu_course() {
		return stu_course;
	}
	public void setStu_course(String stu_course) {
		this.stu_course = stu_course;
	}
	public Integer getStu_number() {
		return stu_number;
	}
	public void setStu_number(Integer stu_number) {
		this.stu_number = stu_number;
	}

}
