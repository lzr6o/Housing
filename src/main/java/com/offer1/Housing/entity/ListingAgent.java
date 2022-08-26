package com.offer1.Housing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "listing_agent")
public class ListingAgent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "license_number")
	private String licenseNumber;
	
	@Column(name = "license_state")
	private String licenseState;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private ListingAgentStatus listingAgentStatus;

}
