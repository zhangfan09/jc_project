package com.jc.mybatisplus.mapper;/*
 *@title ProductMapper
 *@description
 *@author 小沥青
 *@version 1.0
 *@create 2023/6/12 15:21
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.mybatisplus.pojo.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
