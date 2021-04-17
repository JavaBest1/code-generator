package com.best.common.controller;

import com.best.common.service.AbstractService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Controller层基础功能实现
 *
 * @author: JavaBest
 * @date: 2021/4/17 19:22
 */
@SuppressWarnings("all")
public class AbstractController<T> implements PostController<T> {

    @Resource
    private AbstractService service;

    @Override
    @PostMapping("add")
    public int add(@RequestBody T record) {
        return service.save(record);
    }

    @Override
    @PostMapping("delete")
    public int delete(@RequestParam Long id) {
        return service.deleteById(id);
    }

    @Override
    @PostMapping("update")
    public int update(@RequestBody T record) {
        return service.update(record);
    }

    @Override
    @PostMapping("findById")
    public T findById(@RequestParam Long id) {
        return (T) service.findById(id);
    }

    @Override
    @PostMapping("list")
    public PageInfo<T> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "100") Integer size) {
        PageHelper.startPage(page, size);
        List<T> recordList = service.findAll();
        return new PageInfo<>(recordList);
    }
}
