package com.sy.note.enums;

/**
 * SimpleMessage 之 message
 *
 * @author TL
 *
 */
public enum MessageEnum {

	/**
	 * 成功
	 */
	SUCCESS("200", "success"),
	/**
	 * 无权限
	 */
	AUTHORITY("403","没有资源权限"),
	/**
	 * 找不到资源
	 */
	NONE("404","请求资源不存在"),
	/**
	 * 出错
	 */
	ERROR("500","系统繁忙，请联系管理员" );
	
	private String text;
	private String code;
	
	private MessageEnum( String code,String text) {
		this.code = code;
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public String getCode() {
		return code;
	}
	
	public static MessageEnum valueOf(int ordinal) {
		if (ordinal <0 || ordinal>=values().length) {
			throw new IndexOutOfBoundsException("非法的ordinal序号值");
		}

		return values()[ordinal];
	}


}
