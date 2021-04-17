package com.best.common.controller;

import com.github.pagehelper.PageInfo;

/**
 * controller层基础接口
 *
 * @author: JavaBest
 * @date: 2021/4/17 19:20
 */
public interface PostController<T> {

    //新增
    int add(T record);

    //根据id删除
    int delete(Long id);

    // 修改
    int update(T record);

    // 根据id查找详情
    T findById(Long id);

    //分页查询
    PageInfo<T> list(Integer page, Integer size);
}
