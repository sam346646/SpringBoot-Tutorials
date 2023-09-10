package com.sam.springboot.SpringTutorialYoutube.controller;

//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.springboot.SpringTutorialYoutube.model.Location;
import com.sam.springboot.SpringTutorialYoutube.service.LocationService;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/location")
	public String getAllLocation(Model model) {
		model.addAttribute("locations",locationService.getAllLocation());
		return "location";
	}
	
	@RequestMapping(value = "/location/{id}")
	public Optional<Location> getLocation(@PathVariable String id) {
		return locationService.getLocation(id);
	}
	
	@PostMapping(value = "/location/add")
	public void addLocation(@RequestBody Location location) {
		locationService.addLocation(location);
	}
	
	@PutMapping(value = "/location/update/{id}")
	public void updateLocation(@RequestBody Location location,@PathVariable String id) {
		locationService.updateLocation(location,id);
	}
	
	@DeleteMapping(value = "/location/delete/{id}")
	public void deleteLocation(@PathVariable String id) {
		locationService.deleteLocation(id);
	}
}
