package com.best;

/**
 * 常量配置
 *
 * @author: JavaBest
 * @date: 2021/4/17 19:38
 */
public class GeneratorConstant {

    // 项目基础包名称，根据自己公司的项目修改
    public static final String BASE_PACKAGE = "com.best";

    // 实体类所在包
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".entity";

    // Mapper所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";

    // Service所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";

    // ServiceImpl所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";

    // Controller所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";

    // Mapper插件基础接口的完全限定名
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".common.mapper.CrudMapper";
}
