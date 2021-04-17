package com.best.service.impl;

import com.best.common.service.AbstractService;
import com.best.dao.UserMapper;
import com.best.entity.User;
import com.best.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: CodeGenerator
 * @date: 2021-04-17
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    /**
     * 日志服务
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * mapper
     */
    @Resource
    private UserMapper userMapper;
}