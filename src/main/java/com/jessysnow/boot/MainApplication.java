package com.jessysnow.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 主程序类，程序入口
 * 相当于是一个配置类
 *      其中会根据 autoconfig 包中的配置文件进行相应的自动导入
 *      但是因为部分包中 存在 条件配置 注解，所以并不是所有的类都
 *      会被 IOC 容器实例化到容器中
 *
 * 条件配置 : ConditionOnClass
 * 条件配置 : ConditionOnBean
 */
@SpringBootApplication
@ServletComponentScan("com.jessysnow.boot")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
    }
}