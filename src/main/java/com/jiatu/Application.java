package com.jiatu;


import com.jiatu.report.util.SpringUtil;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

@Configuration
@ComponentScan(basePackages = "com.jiatu")
@EnableAutoConfiguration
@ServletComponentScan
public class Application {
    static Logger log = LoggerFactory.getLogger(Application.class);

    @Bean
    ReentrantLock lock(){
        return new ReentrantLock();
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
        log.info("hello world...");
        ReentrantLock lock = (ReentrantLock) SpringUtil.getBean("lock");
        log.info(lock.getClass().getName());
//        new CountDownLatch(1).await();
    }

}