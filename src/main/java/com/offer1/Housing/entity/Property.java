package com.offer1.Housing.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "property")
public class Property {
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_owner_id", referencedColumnName = "id")
    private PrimaryOwner primaryOwner;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "property_type")
	private String propertyType;
	
	@Column(name = "square_feet")
	private Integer squareFeet;
	
	@Column(name = "number_bedrooms")
	private Integer numberBedrooms;
	
	@Column(name = "number_baths")
	private Integer numberBaths;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "owner_type")
	private String ownerType;
	
	@Column(name = "primary_image_url")
	private String primaryImageUrl;
	
	
}
