package com.jc.mybatisplus.service.impl;/*
 *@title UserServiceImpl
 *@description
 *@author 小沥青
 *@version 1.0
 *@create 2023/6/12 10:28
 */

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.mybatisplus.mapper.UserMapper;
import com.jc.mybatisplus.pojo.User;
import com.jc.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author （接口类总设计负责人）:张帆
 * @version （接口版本）:1.0
 * @BelongsProject : mybatisplus
 * @BelongsPackage : com.jc.mybatisplus.service.impl
 * @Description （类/接口类简要描绘，必须以句号为结束）.
 * <p>
 * <strong>提供者：</strong>（提供业务组）
 * <p>
 * <strong>使用者：</strong>（使用业务组，若分方法描述可省略此项）
 * <p>
 * <strong>设计状态：</strong>（指出接口类设计阶段：总体、详细）
 * <p>
 * @CreateTime : 2023-06-12  10:28
 */
@DS("master") //指定所操作的数据源
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
