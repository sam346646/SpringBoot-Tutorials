package com.sam.springboot.SpringTutorialYoutube.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LocationService {

	Location l1 = new Location("l1", "Mangalore");
	Location l2 = new Location("l2", "Bangalore");

	List<Location> locations = new ArrayList<>(Arrays.asList(l1, l2));

	public List<Location> getAllLocation() {
		return locations;
	}

	public Location getLocation(String id) {
		Location location = locations.stream().filter(l -> id.equals(l.getId())).findFirst().orElse(null);
		return location;
	}

	public void addLocation(Location location) {
		locations.add(location);
	}

	public void updateLocation(Location location, String id) {
		for (int i = 0; i < locations.size(); i++) {
			Location l = locations.get(i);
			if (l.getId().equals(id)) {
				locations.set(i, location);
			}
		}
	}

	public void deleteLocation(String id) {
		locations.removeIf(l -> l.getId().equals(id));
	}
}
