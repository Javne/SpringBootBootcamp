package com.javne.SpringApp;

import com.javne.SpringApp.impl.ColorPrinterImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
		log.info("Datasource: " + dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}

