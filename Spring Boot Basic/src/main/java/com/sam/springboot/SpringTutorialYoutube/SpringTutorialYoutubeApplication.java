package com.sam.springboot.SpringTutorialYoutube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.sam.springboot.SpringTutorialYoutube.model.SpringSecurityAuditorAware;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringTutorialYoutubeApplication {

	@Bean
	public AuditorAware<String> auditorAware() {
		 return new SpringSecurityAuditorAware();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringTutorialYoutubeApplication.class, args);
		System.out.println("Hello World!");
	}

}
