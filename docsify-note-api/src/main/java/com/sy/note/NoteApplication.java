package com.sy.note;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description springboot启动类
 * @author dxy
 * @date 2019-12-09
 */
@SpringBootApplication
//@EnableSwagger2
public class NoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteApplication.class, args);
	}

}
