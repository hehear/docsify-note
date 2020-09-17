package com.sy.note.common;

import com.sy.note.enums.MessageEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description 公共rest,对异常信息进行统一处理
 * @author dxy
 * @date 2019-12-12
 */
public class CommonRest<T> {


    private Logger LOGGER = LoggerFactory.getLogger(CommonRest.class);


    public SimpleMessage<T> error(Throwable e) {

        SimpleMessage<T> sm = null;

        //打印出真实的错误信息
        LOGGER.error(e.getMessage(), e);
        sm = new SimpleMessage<T>();
        sm.setCode(MessageEnum.ERROR.getCode());
        //页面反馈至提示"系统繁忙，请联系管理员"
        sm.setMessage(MessageEnum.ERROR.getText());
        //在SimpleMessage中添加 堆栈字段，方便api测试时查看，第三方使用查看
        ((SimpleErrorMessage<T>) sm).setStackTrace(e.getStackTrace());

        return sm;
    }


}
