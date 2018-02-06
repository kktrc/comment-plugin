package com.alm.mybatis.plugin;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Date;

public class QnloftCommentGenerator extends DefaultCommentGenerator {


    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 添加字段注释
        StringBuffer sb = new StringBuffer();
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * <pre>");
        if (introspectedColumn.getRemarks() != null)
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
        sb.append(" * 表字段 : ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" * </pre>");
        field.addJavaDocLine(" * ");
        // addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }




    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

        // 添加字段注释
        StringBuffer sb = new StringBuffer();
        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * <pre>");
        sb.append(" * 表名 : ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());
        innerClass.addJavaDocLine(introspectedTable.getRemarks());
        innerClass.addJavaDocLine(" * </pre>");
        innerClass.addJavaDocLine(" * ");
        innerClass.addJavaDocLine(" */");
    }



    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {

        // 添加字段注释
        StringBuffer sb = new StringBuffer();
        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * <pre>");
        sb.append(" * 表名 : ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());
        innerClass.addJavaDocLine(introspectedTable.getRemarks());
        innerClass.addJavaDocLine(" * </pre>");
        innerClass.addJavaDocLine(" * ");
        innerClass.addJavaDocLine(" */");
    }


    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        // 添加字段注释
        StringBuffer sb = new StringBuffer();
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * <pre>");
        sb.append(" * 表名 : ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(sb.toString());
        String remarks = introspectedTable.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            topLevelClass.addJavaDocLine(" * 备注: " + remarks);
        }
        topLevelClass.addJavaDocLine(" * 生成时间: " + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        topLevelClass.addJavaDocLine(" * </pre>");
        topLevelClass.addJavaDocLine(" * ");
        topLevelClass.addJavaDocLine(" */");
    }
}
