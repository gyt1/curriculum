package com.hp.curriculum;

import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class CurriculumApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurriculumApplication.class, args);
        ParserConfig.getGlobalInstance().addAccept("com.hp.curriculum.model.pojo");

    }
}
