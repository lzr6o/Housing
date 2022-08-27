package com.offer1.Housing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.offer1.Housing.common.ApiRestResponse;
import com.offer1.Housing.entity.Listing;
import com.offer1.Housing.entity.Property;
import com.offer1.Housing.exception.HousingException;
import com.offer1.Housing.exception.HousingExceptionEnum;
import com.offer1.Housing.service.ListingService;

@RestController
@RequestMapping("listing")
public class ListingController {

	@Autowired
	ListingService listingService;

	@GetMapping("/search")
	public ApiRestResponse searchHomes(@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "price", required = false) Double price,
			@RequestParam(value = "numberBedrooms", required = false) Integer numberBedrooms) throws HousingException {
		List<Property> properties = listingService.searchHomes(city, price, numberBedrooms);
		if (properties.size() == 0) {
			return ApiRestResponse.error(HousingExceptionEnum.HOME_NOT_FOUND);
		}
		return ApiRestResponse.success(properties);
	}

	@GetMapping("/getAllHomes")
	public ApiRestResponse getAllHomes() throws HousingException {
		List<Property> properties = listingService.getAllHomes();
		if (properties.size() == 0) {
			return ApiRestResponse.error(HousingExceptionEnum.HOME_NOT_FOUND);
		}
		return ApiRestResponse.success(properties);
	}

	@PostMapping("/createNewListing")
	public ApiRestResponse createNewListing(@RequestBody Property home) throws HousingException {
		Property property = listingService.createNewListing(home);
		if (property == null) {
			return ApiRestResponse.error(HousingExceptionEnum.LISTING_CREATED_FAILED);
		}
		return ApiRestResponse.success(property);
	}

	@PostMapping("/createNewOffer")
	public ApiRestResponse createNewOffer(@RequestParam(value = "price") Double price,
			@RequestParam(value = "state") String state, @RequestParam(value = "propertyID") Long propertyID) throws HousingException {
		Listing offer = listingService.createNewOffer(price, state, propertyID);
		if (offer == null) {
			return ApiRestResponse.error(HousingExceptionEnum.OFFER_CREATED_FAILED);
		}
		return ApiRestResponse.success(offer);
	}

	@GetMapping("/getAllOffers/{homeID}")
	public ApiRestResponse getAllOffers(@PathVariable Long homeID) throws HousingException {
		List<Listing> offers = listingService.getAllOffers(homeID);
		if (offers.size() == 0) {
			return ApiRestResponse.error(HousingExceptionEnum.OFFER_NOT_FOUND);
		}
		return ApiRestResponse.success(offers);
	}
	
}
