package com.jc.mybatisplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 集成Swagger2,两种方式：1.springboot启动类添加注解。2.自定义一个配置类，当前采用第二种。
 */
//@EnableSwagger2
@SpringBootApplication
public class MybatisplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisplusApplication.class, args);
	}

}
