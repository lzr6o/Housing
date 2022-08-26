package com.offer1.Housing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offer1.Housing.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
