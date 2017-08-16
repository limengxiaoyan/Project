package com.magicbeans;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * Created by jesus on 2017/7/10.
 */
public class MpGenerator {


    @Test
    public static void main(String[] args) {
        //初始化代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 输出文件位置
        gc.setOutputDir("F://Tests");
        //是否覆盖已有文件
        gc.setFileOverride(true);
        // 是否开启活动记录  即：一个表对应一个实体，一个字段，对应一个类属性，
        gc.setActiveRecord(true);
        // 是否开启二级缓存
        gc.setEnableCache(false);// XML 二级缓存
        // 是否构建 BaseResultMap
        gc.setBaseResultMap(true);// XML ResultMap
        // 是否构建通用查询结果列
        gc.setBaseColumnList(true);// XML columList
        // 作者名称
        gc.setAuthor("magic-beans");
        mpg.setGlobalConfig(gc);

        //配置数据源信息
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=false");
        mpg.setDataSource(dsc);

        //实体生成策略
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setExclude(new String[]{}); // 排除生成的表
        mpg.setStrategy(strategy);


         TemplateConfig tc = new TemplateConfig();
         tc.setService(null);
         tc.setServiceImpl(null);
         mpg.setTemplate(tc);


        PackageConfig pc = new PackageConfig();
        //设置父包名
        pc.setParent("com.magicbeans");
        mpg.setPackageInfo(pc);



        mpg.execute();

    }
}
