package com.hthyaq.learnadmin.common;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器
 */
public class CodeGenerator {
    private static String[] include = {"company"};

    public static void main(String[] args) throws IOException {
        AutoGenerator mpg = new AutoGenerator();
        String projectPath = System.getProperty("user.dir");
        //全局配置
        GlobalConfig gConfig = new GlobalConfig();
        gConfig.setAuthor("ssq")
                .setOutputDir(projectPath + "/src/main/java")
                .setOpen(false)
                .setFileOverride(true)
                .setIdType(IdType.AUTO)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController");
        mpg.setGlobalConfig(gConfig);

        //数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://47.100.218.177:3306/challenge?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=true&autoReconnect=true")
                .setUsername("root")
                .setPassword("root");
        mpg.setDataSource(dsConfig);

        //包配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.hthyaq.learnadmin")
                .setController("controller")
                .setEntity("model.entity");
        mpg.setPackageInfo(pkConfig);

        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        mpg.setCfg(injectionConfig);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        //策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setSkipView(true)
                .setRestControllerStyle(true)
                .setInclude(include);
        mpg.setStrategy(stConfig);

        //执行
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}