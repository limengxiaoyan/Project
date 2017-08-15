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
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("F://Tests");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(true);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("magic-beans");
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Dengyao7878");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/magic?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setExclude(new String[]{}); // 排除生成的表
        mpg.setStrategy(strategy);


         TemplateConfig tc = new TemplateConfig();
         tc.setService(null);
         tc.setServiceImpl(null);
         mpg.setTemplate(tc);


        PackageConfig pc = new PackageConfig();
        pc.setParent("com.magicbeans");
        mpg.setPackageInfo(pc);



        mpg.execute();

    }
}
