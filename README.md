## 简介
- 使用 FreeMarker 和 Mybatis Generator 实现的代码生成工具，可以通过表名自动生成 Model、Mapper、Service、Controller，
另外还集成了通用Mapper（tk.mybatis），除了一些特殊的业务逻辑之外不需要写任何 SQL，只需要写好实体类及 Mapper 文件中对应的字段
即可支持相应的增删改查方法，大大提高了开发效率。

## 功能特点
- 生成实体类，集成 Lombok 插件，实体类包含表注释
- 生成 Mapper.xml文件，仅包含 BaseResultMap 的字段映射
- 生成 Dao 层的 Mapper 接口类，并集成了 通用 mapper（tk.mybatis），简化开发，代码简洁
- 生成 Service 接口和实现类，基础接口抽象
- 生成 Controller 类，基础接口抽象

