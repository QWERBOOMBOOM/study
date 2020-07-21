package com.cyc.cloud.user.service.impl;

import com.cyc.cloud.user.entity.Book;
import com.cyc.cloud.user.mapper.BookMapper;
import com.cyc.cloud.user.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hsf
 * @since 2020-07-21
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
