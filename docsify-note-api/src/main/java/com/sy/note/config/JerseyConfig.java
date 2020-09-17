package com.sy.note.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.AcceptHeaderApiListingResource;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description Restful框架Jersey资源配置类
 * @author dxy
 * @date 2019-12-09
 */
@Component
public class JerseyConfig extends ResourceConfig {

    @Value("${spring.jersey.application-path}")
    private String apiPath;

    public JerseyConfig(){
        //注册资源
        //register();

        //扫描com.sy.sprite.rest下所有的资源类
        packages("com.sy.note.rest");
    }

    @PostConstruct
    public void init() {
        //注册swagger
        this.configureSwagger();
    }

    /**
     * Jersey整合swagger
     */
    private void configureSwagger() {
        this.register(ApiListingResource.class);
        this.register(AcceptHeaderApiListingResource.class);
        this.register(SwaggerSerializers.class);
        BeanConfig config = new BeanConfig();
        config.setConfigId("note");
        config.setTitle("算法精灵 API接口文档");
        config.setVersion("1.0");
        config.setContact("hehear");
        config.setSchemes(new String[] { "http", "https" });
        config.setBasePath(this.apiPath);
        config.setResourcePackage("com.sy");
        config.setDescription("算法精灵 API接口文档");
        config.setPrettyPrint(true);
        config.setScan(true);
    }
}
