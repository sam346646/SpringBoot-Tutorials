package com.sam.springboot.SpringTutorialYoutube.model;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable("Sam").filter(s->!s.isEmpty());
	}

}
