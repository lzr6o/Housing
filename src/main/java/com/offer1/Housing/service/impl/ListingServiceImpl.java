package com.offer1.Housing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offer1.Housing.entity.Address;
import com.offer1.Housing.entity.Listing;
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
		List<Listing> listings = listingRepository.findByPrice(price);
		if (listings == null) {
			throw new HousingException(HousingExceptionEnum.LISTING_NOT_FOUND);
		}
		List<Property> properties = new ArraryList<>();
		for (Listing listing : listings) {
			Property property = listing.getProperty();
			if (property.getNumberBedrooms() == numberBedrooms) {
				Address address = property.getAddress();
				if (address.getCity().equals(city)) {
					properties.add(property);
				}
			}
		}
		return properties;
	}
	
}