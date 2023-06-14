package com.jc.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.mybatisplus.mapper.BookMapper;
import com.jc.mybatisplus.pojo.Book;
import com.jc.mybatisplus.service.BookService;
import org.springframework.stereotype.Service;

/**
* @author 小沥青
* @description 针对表【book】的数据库操作Service实现
* @createDate 2023-06-12 17:55:55
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService{

}
