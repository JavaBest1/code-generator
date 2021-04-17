package com.best.controller;

import com.best.common.controller.AbstractController;
import com.best.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: CodeGenerator
 * @date: 2021-04-17
 */
@RestController
@RequestMapping("user")
public class UserController extends AbstractController<User> {
}