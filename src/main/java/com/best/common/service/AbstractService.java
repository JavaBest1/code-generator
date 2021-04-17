package com.best.common.service;

import com.best.common.mapper.CrudMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基于通用Mapper的Service层基础功能实现
 *
 * @author: JavaBest
 * @date: 2021/4/17 19:12
 */
public class AbstractService<T> implements Service<T> {

    @Resource
    protected CrudMapper<T> crudMapper;

    private Class<T> modelClass;

    @SuppressWarnings("unchecked")
    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public int save(T record) {
        return crudMapper.insertSelective(record);
    }

    @Override
    public int save(List<T> recordList) {
        return crudMapper.insertList(recordList);
    }

    @Override
    public int deleteById(Long id) {
        return crudMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIds(String ids) {
        return crudMapper.deleteByIds(ids);
    }

    @Override
    public int deleteByCondition(Condition condition) {
        return crudMapper.deleteByCondition(condition);
    }

    @Override
    public int update(T record) {
        return crudMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public T findById(Long id) {
        return crudMapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String filedName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(filedName);
            field.setAccessible(true);
            field.set(model, value);
            return crudMapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public List<T> findByIds(String ids) {
        return crudMapper.selectByIds(ids);
    }

    @Override
    public List<T> findByCondition(Condition condition) {
        return crudMapper.selectByCondition(condition);
    }

    @Override
    public List<T> findAll() {
        return crudMapper.selectAll();
    }

    @Override
    public int countByCondition(Condition condition) {
        return crudMapper.selectCountByCondition(condition);
    }
}
