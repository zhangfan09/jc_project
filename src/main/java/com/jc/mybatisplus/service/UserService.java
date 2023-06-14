package com.jc.mybatisplus.service;/*
 *@title UserService
 *@description
 *@author 小沥青
 *@version 1.0
 *@create 2023/6/12 10:27
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.jc.mybatisplus.pojo.User;
import org.springframework.stereotype.Service;
/**
 * UserService继承IService模板提供的基础功能
 */

@Service
public interface UserService  extends IService<User> {

}
