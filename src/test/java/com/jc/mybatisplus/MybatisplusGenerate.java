package com.jc.mybatisplus;/*
 *@title MybatisplusGenerate
 *@description
 *@author 小沥青
 *@version 1.0
 *@create 2023/6/12 17:05
 */

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * @author （接口类总设计负责人）:张帆
 * @version （接口版本）:1.0
 * @BelongsProject : mybatisplus
 * @BelongsPackage : com.jc.mybatisplus
 * @Description （代码生成器。）.
 * <p>
 * <strong>提供者：</strong>（提供业务组）
 * <p>
 * <strong>使用者：</strong>（使用业务组，若分方法描述可省略此项）
 * <p>
 * <strong>设计状态：</strong>（指出接口类设计阶段：总体、详细）
 * <p>
 * @CreateTime : 2023-06-12  17:05
 */
@SpringBootTest
public class MybatisplusGenerate {

    /**
     * 代码生成器
     */
    @Test
    public void GenerateMessage() {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/jc_shop?characterEncoding=utf-8&userSSL=false", "root", "root")
                .globalConfig(builder -> {
                    builder.author("jc") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://Java//generate"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.jc") // 设置父包名
                            .moduleName("mybatisplus") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://Java//generate"));
                    // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine())
                // 使用Freemarker 引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
