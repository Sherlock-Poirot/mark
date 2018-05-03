package com.detective.mark1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.detective.mark1.mapper")
public class Mark1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mark1Application.class, args);
	}
}
