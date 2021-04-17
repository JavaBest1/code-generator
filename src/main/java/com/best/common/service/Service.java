package com.best.common.service;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service层基础接口
 *
 * @author: JavaBest
 * @date: 2021/4/17 19:06
 */
public interface Service<T> {

    // 单条插入
    int save(T record);

    // 批量插入
    int save(List<T> recordList);

    // 通过主键删除
    int deleteById(Long id);

    // 通过id批量删除 ids -> "1,2,3"
    int deleteByIds(String ids);

    // 条件删除
    int deleteByCondition(Condition condition);

    // 更新
    int update(T record);

    // 通过id查找
    T findById(Long id);

    // 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
    T findBy(String filedName, Object value) throws TooManyResultsException;

    // 通过多个id查找，ids -> "1,2,3"
    List<T> findByIds(String ids);

    // 条件查找
    List<T> findByCondition(Condition condition);

    // 获取所有
    List<T> findAll();

    //条件数量查询
    int countByCondition(Condition condition);
}
