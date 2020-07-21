package com.cyc.cloud.user.service.impl;

import com.cyc.cloud.user.entity.Author;
import com.cyc.cloud.user.mapper.AuthorMapper;
import com.cyc.cloud.user.service.AuthorService;
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
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements AuthorService {

}
