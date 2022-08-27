package com.offer1.Housing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offer1.Housing.entity.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

	List<Listing> findByPrice(Double price);
	
}
