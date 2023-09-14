package com.sam.SpringWithMongodb;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sam.SpringWithMongodb.model.Address;
import com.sam.SpringWithMongodb.model.Gender;
import com.sam.SpringWithMongodb.model.Student;
import com.sam.SpringWithMongodb.repository.StudentRepo;

@SpringBootApplication
public class SpringWithMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithMongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepo repo) {
		return args -> {
			Address address=new Address("Konaje","DK",574199);
			Student student=new Student("Steephan","Manohar","stpn@gmail.com",Gender.MALE,address,List.of("CS","EC"),BigDecimal.TEN,LocalDateTime.now());
	
			repo.insert(student);
		};
	}
}
