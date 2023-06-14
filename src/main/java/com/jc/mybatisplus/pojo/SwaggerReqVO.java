package com.jc.mybatisplus.pojo;

/**
 * @author （接口类总设计负责人）:张帆
 * @version （接口版本）:1.0
 * @BelongsProject : mybatisplus
 * @BelongsPackage : com.jc.mybatisplus.controller
 * @Description 测试Swagger2请求。
 * <p>
 * <strong>提供者：</strong>（提供业务组）
 * <p>
 * <strong>使用者：</strong>（使用业务组，若分方法描述可省略此项）
 * <p>
 * <strong>设计状态：</strong>（指出接口类设计阶段：总体、详细）
 * <p>
 * @CreateTime : 2023-06-14  09:52
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ApiModel() ：用于响应实体类上，用于说明实体作用
 * description="描述实体的作用"
 */
@Data
@ApiModel("创建Swagger请求参数")
public class SwaggerReqVO {
    @ApiModelProperty("id")
    private Integer id;

    /**
     * @ApiModelProperty： 用在属性上，描述实体类的属性
     * value="用户名"  描述参数的意义
     * name="name"    参数的变量名
     * required=true     参数是否必选
     */
    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private Integer gender;

}
