package ${basePackage}.service.impl;

import ${basePackage}.common.service.AbstractService;
import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: ${author}
 * @date: ${date}
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    /**
     * 日志服务
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(${modelNameUpperCamel}ServiceImpl.class);

    /**
     * mapper
     */
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;
}