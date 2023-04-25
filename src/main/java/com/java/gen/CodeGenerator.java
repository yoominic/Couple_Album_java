package com.java.gen;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @ClassName CodeGenerator
 * @Description TODO
 * @Author yoominic
 * @Date 2022/7/26 11:40 周二
 * @Version 1.0.0
 **/
public class CodeGenerator {
    public static void main(String[] args) {
        /**
         * 第一步：  使用代码生成器
         */
        //怎么用代码生成器呢？
        //    1.创建代码生成器对象
        //    2.执行代码生成器    //mp包里面的AutoGenerator
        AutoGenerator autoGenerator = new AutoGenerator();
        //    告诉它怎么生成，在哪生成
        //datasource数据源配置
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/album_couple?serverTimezone=UTC&nullCatalogMeansCurrent=true");
        dataSource.setUsername("root");
        dataSource.setPassword("Dty@998!!");
        dataSource.setDbType(DbType.MYSQL);
        autoGenerator.setDataSource(dataSource);

        //会在D盘生成一个com文件，但是这个位置是不对的，需要我们再进一步配置
        /**
         * 第二步：    设置全局配置
         */
        GlobalConfig globalConfig = new GlobalConfig();
        //默认输出D盘根下，设置到这一目录下  mybatis_04-generator/src/main/java
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java/");
        //globalConfig.setOutputDir(System.getProperty("user.dir")+"\\src\\main\\java");
        //      \\src\\main\\java
        //设置完之后是否打开资源管理器   NO
        globalConfig.setOpen(false);
        //设置作者
        globalConfig.setAuthor("yoominic");
        //设置是否覆盖原始生成的文件
        globalConfig.setFileOverride(false);
        //设置数据层接口名，%s为占位符  代表数据库中的表名或模块名
        globalConfig.setMapperName("%sMapper");
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        //设置id生成策略
        globalConfig.setIdType(IdType.ASSIGN_UUID);
        autoGenerator.setGlobalConfig(globalConfig);

        /**
         * 第三步：    设置包名相关配置
         */
        PackageConfig packageConfig = new PackageConfig();
        //设置生成的包名，与代码所在位置不冲突，二者叠加组成完整路径
        packageConfig.setParent("com.java");
        //设置实体类包名
        packageConfig.setEntity("pojo");
        //设置数据层包名
        packageConfig.setMapper("mapper");

        packageConfig.setService("service");
        autoGenerator.setPackageInfo(packageConfig);


        /**
         * 第四步：   策略设置
         */

        StrategyConfig strategyConfig = new StrategyConfig();
        //设置数据库表的前缀名称，模块名=数据库表名-前缀名   User=tbl_user - tbl_
        strategyConfig.setInclude("t_user");
        strategyConfig.setTablePrefix("cz_");
        //是否启用Rest风格
        strategyConfig.setRestControllerStyle(true);
        //设置乐观锁字段名
        strategyConfig.setVersionFieldName("version");
        //设置逻辑删除字段名
        strategyConfig.setLogicDeleteFieldName("deleted");
        //设置是否启用Lombok
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setCapitalMode(true);
//        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        autoGenerator.setStrategy(strategyConfig);


        autoGenerator.execute();//执行
    }


}
