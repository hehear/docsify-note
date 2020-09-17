package com.sy.note.common;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 *
 * @author TL
 * @date 2018-11-07
 * 
 */
public class Pager<T>  implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	
    /**
     * 数据量
     */ 
	private int dataCount;
	/**
	 * 当前页码
	 */ 
	private int pageIndex=1;
	/**
	 * 单页数据量
	 */
	private int pageSize=10;
	/**
	 * 总页数（根据数据量和页面尺寸自动计算）
	 */
	private int pageCount;
	/**
	 * 当前页面数据起始
	 */
	private int from;
	/**
	 * 当前页面数据截止
	 */
	private int to;
	/**
	 * 页面数据集
	 */
	private List<T> list;
	 
	public int getDataCount() {
		return dataCount;
	}
	 
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
		//计算页数
		calPageCount();
		//计算起止
		calFromTo();
	}
	 
	public int getPageIndex() {
		return pageIndex;
	}
	 
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	 
	public int getPageSize() {
		return pageSize;
	}
	 
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	 
	public int getPageCount() {
		return pageCount;
	}
	 
	 
	 
	public List<T> getList() {
		return list;
	}
	 
	public void setList(List<T> list) {
		this.list = list;
	}
	
 
	public int getFrom() {
		return from;
	}
 
	public int getTo() {
		return to;
	}
 

	//根据数据量和页面尺寸计算页数
	private void calPageCount(){
		if(this.dataCount!=0 && this.pageSize!=0){
			this.pageCount=this.dataCount%this.pageSize==0?this.dataCount/this.pageSize:this.dataCount/this.pageSize+1;
		}
	} 
	
	//计算页面数据起始截止位置
	private void calFromTo(){
		if(this.dataCount!=0 && this.pageSize!=0 &&this.pageIndex!=0){
			this.from=this.pageSize*(this.pageIndex-1)+1;
			this.to=this.pageSize*(this.pageIndex)>this.dataCount?this.dataCount:this.pageSize*(this.pageIndex);
		}
	} 
	 

}
