package com.jeff.auth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jeff.auth2.mapper")
public class Auth2ServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Auth2ServiceDemoApplication.class, args);
	}

}
