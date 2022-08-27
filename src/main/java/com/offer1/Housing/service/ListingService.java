package com.offer1.Housing.service;

import java.util.List;

import com.offer1.Housing.entity.Listing;
import com.offer1.Housing.entity.Property;

public interface ListingService {

	List<Property> searchHomes(String city, Double price, Integer numberBedrooms);

	List<Property> getAllHomes();

	Listing createNewListing(Double price, String state, Property property);

	
	
}
