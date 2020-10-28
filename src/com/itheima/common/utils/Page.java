package com.itheima.common.utils;
import java.util.List;
public class Page<T> {
	private int totalSize;    // 总条数
	private int currentPage;     // 当前页码
	private int pageSize;     // 每页显示的条数
	private List<T> pageList; // 封装后的列表结果集
	private int totalPage;


	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	public int getTotalPage()
	{
		if(totalSize%pageSize == 0)
		{
			totalPage = totalSize/pageSize;
		}else{
			totalPage = totalSize/pageSize + 1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}



}
