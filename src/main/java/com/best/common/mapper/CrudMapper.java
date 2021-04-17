package com.best.common.mapper;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 基础增删改查通用mapper,包含基础增删改查功能、根据id批量查询、批量插入等功能。
 * 如需其它接口参考官方文档自行添加
 *
 * @author: JavaBest
 * @date: 2021/4/17 19:00
 */
public interface CrudMapper<T> extends BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}
