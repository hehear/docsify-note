package com.sy.note.common;


import com.sy.note.enums.MessageEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @description 封装统一的返回数据
 * @author dxy
 * @date 2019-12-12
 *
 * @param <T>
 */

@ApiModel(description = "通用响应返回对象")
public class SimpleMessage<T> {
	 
	//状态码
	@ApiModelProperty("状态码")
	private String code;
	//状态信息
	@ApiModelProperty("状态信息")
	private String message;
	//对象信息
	@ApiModelProperty("返回对象")
	private Object record;
	//对象集合信息
	@ApiModelProperty("返回对象集合")
	private List<T> records;
	//分页信息
	@ApiModelProperty("分页信息")
	private Pager pager;
 
	//默认是成功
	public SimpleMessage(){
		code= MessageEnum.SUCCESS.getCode();
		message=MessageEnum.SUCCESS.getText();
	} 

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getRecord() {
		return record;
	}

	public void setRecord(Object record) {
		this.record = record;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
}
