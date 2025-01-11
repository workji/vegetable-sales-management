package com.farm.vegetablesales;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 野菜販売管理システムのメインアプリケーションクラス
 */
@SpringBootApplication
public class VegetableSalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(VegetableSalesApplication.class, args);
    }
}