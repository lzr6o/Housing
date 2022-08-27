package com.offer1.Housing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offer1.Housing.common.ApiRestResponse;
import com.offer1.Housing.entity.Property;
import com.offer1.Housing.exception.HousingException;
import com.offer1.Housing.exception.HousingExceptionEnum;
import com.offer1.Housing.service.ListingService;

@RestController
@RequestMapping("listing")
public class ListingController {
	
	@Autowired
	ListingService listingService;
	
	@GetMapping("/search/{city}/{price}/{numberBedrooms}")
	public ApiRestResponse searchHomes(@PathVariable String city, @PathVariable Double price, @PathVariable Integer numberBedrooms) throws HousingException {
		List<Property> properties = listingService.searchHomes(city, price, numberBedrooms);
		if (properties == null) {
			return ApiRestResponse.error(HousingExceptionEnum.HOME_NOT_FOUND);
		}
		return ApiRestResponse.success(properties);
	}
	
	
}
