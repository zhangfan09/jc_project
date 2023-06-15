package com.jc.mybatisplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author （接口类总设计负责人）:张帆
 * @version （接口版本）:1.0
 * @BelongsProject : mybatisplus
 * @BelongsPackage : com.jc.mybatisplus.controller
 * @Description （类/接口类简要描绘，必须以句号为结束）.
 * <p>
 * <strong>提供者：</strong>（提供业务组）
 * <p>
 * <strong>使用者：</strong>（使用业务组，若分方法描述可省略此项）
 * <p>
 * <strong>设计状态：</strong>（指出接口类设计阶段：总体、详细）
 * <p>
 * @CreateTime : 2023-06-15  22:36
 */
@Controller
@RequestMapping("/Order")
public class OrderController {


    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name","冰箱");
        map.put("type","电器");
        map.put("num","30");
        System.out.println("map = " + map);
        System.out.println("第一次更改内容，冰箱的数量");
    }
}
