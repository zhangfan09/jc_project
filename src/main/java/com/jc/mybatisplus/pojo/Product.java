package com.jc.mybatisplus.pojo;/*
 *@title Product
 *@description
 *@author 小沥青
 *@version 1.0
 *@create 2023/6/12 15:20
 */

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author （接口类总设计负责人）:张帆
 * @version （接口版本）:1.0
 * @BelongsProject : mybatisplus
 * @BelongsPackage : com.jc.mybatisplus.pojo
 * @Description （类/接口类简要描绘，必须以句号为结束）.
 * <p>
 * <strong>提供者：</strong>（提供业务组）
 * <p>
 * <strong>使用者：</strong>（使用业务组，若分方法描述可省略此项）
 * <p>
 * <strong>设计状态：</strong>（指出接口类设计阶段：总体、详细）
 * <p>
 * @CreateTime : 2023-06-12  15:20
 */
@Data
@TableName("product")
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;
}
