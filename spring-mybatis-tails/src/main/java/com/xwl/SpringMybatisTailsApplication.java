package com.xwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringMybatisTailsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisTailsApplication.class, args);
    }

}
