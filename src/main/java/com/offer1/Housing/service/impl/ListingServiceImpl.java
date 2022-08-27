package com.offer1.Housing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offer1.Housing.entity.Address;
import com.offer1.Housing.entity.Listing;
import com.offer1.Housing.entity.ListingState;
import com.offer1.Housing.entity.Property;
import com.offer1.Housing.exception.HousingException;
import com.offer1.Housing.exception.HousingExceptionEnum;
import com.offer1.Housing.repository.AddressRepository;
import com.offer1.Housing.repository.ListingRepository;
import com.offer1.Housing.repository.PropertyRepository;
import com.offer1.Housing.service.ListingService;

@Service
public class ListingServiceImpl implements ListingService {

	@Autowired
	ListingRepository listingRepository;

	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public List<Property> searchHomes(String city, Double price, Integer numberBedrooms) {
		List<Listing> listings = new ArrayList<>();
		listings = price != null ? listingRepository.findByPrice(price) : listingRepository.findAll();
		if (listings == null) {
			throw new HousingException(HousingExceptionEnum.LISTING_NOT_FOUND);
		}
		List<Property> properties = new ArrayList<>();
		for (Listing listing : listings) {
			Property property = listing.getProperty();
			if (numberBedrooms == null || property.getNumberBedrooms() == numberBedrooms) {
				Address address = property.getAddress();
				if (city.length() == 0 || address.getCity().equals(city)) {
					properties.add(property);
				}
			}
		}
		return properties;
	}

	@Override
	public List<Property> getAllHomes() {
		List<Property> properties = propertyRepository.findAll();
		if (properties == null) {
			throw new HousingException(HousingExceptionEnum.HOME_NOT_FOUND);
		}
		return properties;
	}
	
	@Override
	public Listing createNewListing(Double price, String state, Property property) {
		ListingState listingState = ListingState.valueOf(state);
		Listing listing = new Listing(price, listingState, property);
		listingRepository.save(listing);
		return listing;
	}

	@Override
	public 
	
}