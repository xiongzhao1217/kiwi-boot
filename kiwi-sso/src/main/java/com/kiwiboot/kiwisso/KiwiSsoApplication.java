package com.kiwiboot.kiwisso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.kiwiboot.kiwisso.dao")
@SpringBootApplication
public class KiwiSsoApplication {

	private static Logger logger = LoggerFactory.getLogger(KiwiSsoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KiwiSsoApplication.class, args);
		logger.info("Kiwi SSO started!");
	}
}
