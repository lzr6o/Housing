package com.offer1.Housing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offer1.Housing.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{
	
	List<Property> findByNumberBedrooms(Integer numberBedrooms);
	
}
