package com.offer1.Housing.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public Property createNewListing(Property property) {
		propertyRepository.save(property);
		return property;
	}

	@Override
	public Listing createNewOffer(Double price, String state, Long propertyID) {
		ListingState listingState = ListingState.valueOf(state);
		Optional<Property> optionalProperty = propertyRepository.findById(propertyID);
		Property property = optionalProperty.orElseThrow(() -> new HousingException(HousingExceptionEnum.PROPERTY_NOT_FOUND));
		Listing offer = new Listing(price, listingState, property);
		listingRepository.save(offer);
		return offer;
	}

	@Override
	public List<Listing> getAllOffers(Long propertyID) {
		List<Listing> offers = listingRepository.findByPropertyId(propertyID);
		return offers;
	}

}