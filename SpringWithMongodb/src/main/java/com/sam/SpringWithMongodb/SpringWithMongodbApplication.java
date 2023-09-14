package com.sam.SpringWithMongodb;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

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
	CommandLineRunner runner(StudentRepo repo, MongoTemplate mongoTemplate) {
		return args -> {
			String email="kiran@gmail.com";
			Address address=new Address("Konaje","DK",574199);
			Student student=new Student("Kiran","GK",email,Gender.MALE,address,List.of("CS","EC"),BigDecimal.TEN,LocalDateTime.now());
	
//			Query query=new Query();
//			query.addCriteria(Criteria.where("email").is("stpn@gmail.com"));
//			List<Student> students= mongoTemplate.find(query, Student.class);
//			System.out.println(students);
//			
//			if(students.size()>1) {
//				throw new IllegalStateException("Found more than one students.");
//			}
//			if(students.isEmpty()) {
//				System.out.println("Inserting student "+student);
//				repo.insert(student);
//			}
//			else {
//				System.out.println(student+" Already exists.");
//			}
			
			repo.findStudentByEmail(email)
			.ifPresentOrElse(
			s ->  { 
				System.out.println(s+" already exists."); 
			}
			, 
			() -> { 
				System.out.println("Inserting student "+student);
				repo.insert(student);
			});
		};
	}
}
