package ${basePackage}.controller;

import ${basePackage}.common.controller.AbstractController;
import ${basePackage}.entity.${modelNameUpperCamel};
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: ${author}
 * @date: ${date}
 */
@RestController
@RequestMapping("${modelNameLowerCamel}")
public class ${modelNameUpperCamel}Controller extends AbstractController<${modelNameUpperCamel}> {
}