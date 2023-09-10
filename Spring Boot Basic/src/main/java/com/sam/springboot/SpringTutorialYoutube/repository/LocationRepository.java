package com.sam.springboot.SpringTutorialYoutube.repository;

import org.springframework.data.repository.CrudRepository;

import com.sam.springboot.SpringTutorialYoutube.model.Location;

public interface LocationRepository extends CrudRepository<Location, String>{
 
}
