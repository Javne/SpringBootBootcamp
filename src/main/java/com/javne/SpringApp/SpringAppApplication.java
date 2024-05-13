package com.javne.SpringApp;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Log
@SpringBootApplication
@AllArgsConstructor
public class SpringAppApplication implements CommandLineRunner {


	private final DataSource dataSource;


	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}

