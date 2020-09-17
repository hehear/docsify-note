package com.sy.note.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * @description 业务异常统一处理类，除了Jersey提供的标准异常，自定义业务异常
 * @author dxy
 * @date 2019-12-10
 */
public class BizException extends WebApplicationException {

    public BizException(){
        //定义http状态
        super(Response.Status.NOT_FOUND);
    }

    public BizException(String message){
        //定义异常信息
        super(message);
    }

}
