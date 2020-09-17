package com.sy.note.rest;

import com.sy.note.common.CommonRest;
import com.sy.note.common.SimpleMessage;
import com.sy.note.service.INoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileWriter;

/**
 * @description note接口类
 * @author dxy
 * date 2019-12-10
 */
@Path("sort")
@Api(value = "note接口")
public class NoteRest extends CommonRest{

    private Logger LOGGER = LoggerFactory.getLogger(NoteRest.class);

    @Autowired
    private INoteService quickSortService;

    @Value("${docsify.note.path}")
    private String templatePath;


    @POST
    @Path("saveNote")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="保存笔记", notes="保存笔记Rest方法")
    @ApiResponse(code = 200,message = "成功",response = SimpleMessage.class)
    public SimpleMessage<String> saveNote(@RequestParam("name") String name, @RequestParam("content") String content ){

        SimpleMessage<String> simpleMessage = null;

        FileWriter fw;
        try {

            LOGGER.info("保存笔记。。");
            //保存note md文件
            fw = new FileWriter(templatePath+name+".md");
            fw.write(content);
            fw.close();

            simpleMessage = new SimpleMessage<>();

            simpleMessage.setRecord("保存成功");

        }catch (Exception e){

            return error(e);
        }

        return simpleMessage;

    }


}
