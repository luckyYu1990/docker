package com.example.yu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@ComponentScan("com.example.yu")
@MapperScan("com.example.yu.mapper")*/
public class YuApplication {

	public static void main(String[] args) {
		SpringApplication.run(YuApplication.class, args);
	}

}
