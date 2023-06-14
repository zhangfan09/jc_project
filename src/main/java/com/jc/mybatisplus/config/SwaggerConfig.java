package com.jc.mybatisplus.config;/*
 *@title SwaggerConfig
 *@description
 *@author 小沥青
 *@version 1.0
 *@create 2023/6/14 9:46
 */

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author （接口类总设计负责人）:张帆
 * @version （接口版本）:1.0
 * @BelongsProject : mybatisplus
 * @BelongsPackage : com.jc.mybatisplus.config
 * @Description Swagger2自定义配置类
 * <p>
 * <strong>提供者：</strong>（提供业务组）
 * <p>
 * <strong>使用者：</strong>（使用业务组，若分方法描述可省略此项）
 * <p>
 * <strong>设计状态：</strong>（指出接口类设计阶段：总体、详细）
 * <p>
 * @CreateTime : 2023-06-14  09:46
 */

/**
 * @EnableSwaggerBootstrapUI:swagger增强页面注解
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.jc.mybatisplus.controller")).paths(PathSelectors.any())
                .build();//.globalOperationParameters(setHeaderToken())

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("action-swagger").description("swagger实战").termsOfServiceUrl("")
                .version("1.0").build();
    }

    /**
     * 设置swagger文档中全局参数
     * @Date: 2023/06/14 09:49
     * @return java.util.List<springfox.documentation.service.Parameter>
     */
    private List<Parameter> setHeaderToken() {
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder userId = new ParameterBuilder();
        userId.name("token").description("用户TOKEN").modelRef(new ModelRef("string")).parameterType("header")
                .required(true).build();
        pars.add(userId.build());
        return pars;
    }
}
