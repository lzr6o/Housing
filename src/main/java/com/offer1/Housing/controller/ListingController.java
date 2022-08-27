package com.offer1.Housing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offer1.Housing.common.ApiRestResponse;

@RestController
@RequestMapping("listing")
public class ListingController {
	
	@GetMapping("/search/{city}/{price}/{numberBedrooms}")
	public ApiRestResponse searchHomes(@PathVariable String city, @PathVariable Double price, @PathVariable Integer numberBedrooms) {
		return ApiRestResponse.success();
	}
	
	
}
