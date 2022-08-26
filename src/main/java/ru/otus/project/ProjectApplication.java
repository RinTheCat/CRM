package ru.otus.project;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(ProjectApplication.class, args);

//		Console.main(args);
	}

}
