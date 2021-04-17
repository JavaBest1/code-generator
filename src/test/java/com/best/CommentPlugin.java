package com.best;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;
import tk.mybatis.mapper.generator.MapperCommentGenerator;

import java.text.MessageFormat;
import java.util.Properties;
import java.util.Set;

/**
 * 注释插件
 *
 * @author: JavaBest
 * @date: 2021/4/17 19:36
 */
public class CommentPlugin extends MapperCommentGenerator {

    private String beginningDelimiter = "`";
    private String endingDelimiter = "`";
    private boolean forceAnnotation;


    @Override
    public void addConfigurationProperties(Properties properties) {
        String beginningDelimiter = properties.getProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER);
        if (StringUtility.stringHasValue(beginningDelimiter)) {
            this.beginningDelimiter = beginningDelimiter;
        }
        String endingDelimiter = properties.getProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER);
        if (StringUtility.stringHasValue(endingDelimiter)) {
            this.endingDelimiter = endingDelimiter;
        }
        String forceAnnotation = properties.getProperty("forceAnnotation");
        if (StringUtility.stringHasValue(forceAnnotation))
            this.forceAnnotation = forceAnnotation.equalsIgnoreCase("TRUE");

    }

    public String getDelimiterName(String name) {
        if (name.startsWith("`") && name.endsWith("`")) {
            return name;
        }
        StringBuilder nameBuilder = new StringBuilder();
        nameBuilder.append(this.beginningDelimiter);
        nameBuilder.append(name);
        nameBuilder.append(this.endingDelimiter);
        return nameBuilder.toString();
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
//			StringBuilder sb;
//			sb = new StringBuilder();
//			sb.append("/** ");
//			sb.append(introspectedColumn.getRemarks().toUpperCase().toString());
//			sb.append(" */");
//			field.addJavaDocLine(sb.toString());

            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * "+introspectedColumn.getRemarks());
            field.addJavaDocLine(" */");
        }

        if (field.isTransient()) {
            field.addAnnotation("@Transient");
        }
        for (IntrospectedColumn column : introspectedTable.getPrimaryKeyColumns()) {
            if (introspectedColumn == column) {
                field.addAnnotation("@Id");
                break;
            }
        }
        String column = introspectedColumn.getActualColumnName();
        if ((StringUtility.stringContainsSpace(column))
                || (introspectedTable.getTableConfiguration().isAllColumnDelimitingEnabled())) {
            column = new StringBuilder().append(introspectedColumn.getContext().getBeginningDelimiter()).append(column)
                    .append(introspectedColumn.getContext().getEndingDelimiter()).toString();
        }

        if (!column.equals(introspectedColumn.getJavaProperty())) {
            System.out.println("1column:" + column+","+introspectedColumn.isColumnNameDelimited());

            field.addAnnotation(new StringBuilder().append("@Column(name = \"").append(getDelimiterName(column))
                    .append("\")").toString());
//		} else if ((StringUtility.stringHasValue(this.beginningDelimiter))
//				|| (StringUtility.stringHasValue(this.endingDelimiter))) {
//			System.out.println("2column:" + column);
//			field.addAnnotation(
//					new StringBuilder().append("@Column(name = \"").append(column).append("\")").toString());
        } else if (this.forceAnnotation) {
            System.out.println("3column:" + column);
            field.addAnnotation(
                    new StringBuilder().append("@Column(name = \"").append(column).append("\")").toString());
        }
        if (introspectedColumn.isIdentity()) {
            if (introspectedTable.getTableConfiguration().getGeneratedKey().getRuntimeSqlStatement().equals("JDBC"))
                field.addAnnotation("@GeneratedValue(generator = \"JDBC\")");
            else
                field.addAnnotation("@GeneratedValue(strategy = GenerationType.IDENTITY)");
        } else if (introspectedColumn.isSequenceColumn()) {
            String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
            String sql = MessageFormat.format(
                    introspectedTable.getTableConfiguration().getGeneratedKey().getRuntimeSqlStatement(),
                    new Object[] { tableName, tableName.toUpperCase() });
            field.addAnnotation(
                    new StringBuilder().append("@GeneratedValue(strategy = GenerationType.IDENTITY, generator = \"")
                            .append(sql).append("\")").toString());
        }
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
        // TODO Auto-generated method stub
//		super.addGetterComment(method, introspectedTable, introspectedColumn);
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
        // TODO Auto-generated method stub
//		super.addSetterComment(method, introspectedTable, introspectedColumn);
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,
                                           Set<FullyQualifiedJavaType> imports) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,
                                           IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,
                                   Set<FullyQualifiedJavaType> imports) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,
                                   IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable,
                                   Set<FullyQualifiedJavaType> imports) {
        // TODO Auto-generated method stub

    }
}
