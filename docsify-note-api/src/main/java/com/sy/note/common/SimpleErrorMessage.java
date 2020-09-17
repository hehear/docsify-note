package com.sy.note.common;

/**
 * 异常时返回的simpleMessage
 * 
 * @author TL
 * @date 2018-12-05
 *
 * @param <T>
 */
public class SimpleErrorMessage<T> extends SimpleMessage<T> {
	
	/**
	 * 堆栈信息
	 */
	private StackTraceElement[] stackTrace;

	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(StackTraceElement[] stackTrace) {
		this.stackTrace = stackTrace;
	} 
	
	
}
