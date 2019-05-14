package dev.gdev.readcode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("dev.gdev.readcode.mapper")
public class ReadcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadcodeApplication.class, args);
    }

}
