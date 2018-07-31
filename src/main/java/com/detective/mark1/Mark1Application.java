package com.detective.mark1;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@MapperScan(basePackages = "com.detective.mark1.mapper")
@Log4j2
public class Mark1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mark1Application.class, args);
	}
}
