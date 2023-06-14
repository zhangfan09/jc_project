package com.jc.mybatisplus.pojo;/*
 *@title SwaggerResVO
 *@description
 *@author 小沥青
 *@version 1.0
 *@create 2023/6/14 10:15
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author （接口类总设计负责人）:张帆
 * @version （接口版本）:1.0
 * @BelongsProject : mybatisplus
 * @BelongsPackage : com.jc.mybatisplus.pojo
 * @Description Swagger2响应类.
 * <p>
 * <strong>提供者：</strong>（提供业务组）
 * <p>
 * <strong>使用者：</strong>（使用业务组，若分方法描述可省略此项）
 * <p>
 * <strong>设计状态：</strong>（指出接口类设计阶段：总体、详细）
 * <p>
 * @CreateTime : 2023-06-14  10:15
 */
@Data
@ApiModel("创建Swagger响应结果")
public class SwaggerResVO {


    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private Integer gender;

    @ApiModelProperty("啥啥")
    private String what;

}
