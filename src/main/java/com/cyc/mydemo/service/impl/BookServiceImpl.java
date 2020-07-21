package com.cyc.mydemo.service.impl;

import com.cyc.mydemo.entity.Book;
import com.cyc.mydemo.mapper.BookMapper;
import com.cyc.mydemo.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyc
 * @since 2020-07-21
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
