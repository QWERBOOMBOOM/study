package com.cyc.mydemo.service.impl;

import com.cyc.mydemo.entity.Author;
import com.cyc.mydemo.mapper.AuthorMapper;
import com.cyc.mydemo.service.AuthorService;
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
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements AuthorService {

}
