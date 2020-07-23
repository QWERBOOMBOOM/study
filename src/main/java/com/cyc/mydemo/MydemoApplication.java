package com.cyc.mydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cyc.mydemo.mapper")
public class MydemoApplication {

    public static void main(String[] args) {
        long startTIme = System.currentTimeMillis();
        System.out.println("------------------程序开始启动------------------");
        SpringApplication.run(MydemoApplication.class, args);
        long endTime = System.currentTimeMillis()-startTIme;
        System.out.println("------------------程序启动结束，耗时："+endTime/60+"s------------------");

    }

}
