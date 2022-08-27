package com.offer1.Housing.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "listing")
public class Listing {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "property_id", referencedColumnName = "id")
	private Property property;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "escrow_company_id", referencedColumnName = "id")
	private EscrowCompany escrowCompany;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "title_company_id", referencedColumnName = "id")
	private TitleCompany titleCompany;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "listing_agent_id", referencedColumnName = "id")
	private ListingAgent listingAgent;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "included_items_id", referencedColumnName = "id")
	private IncludedItems includedItems;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "excluded_items_id", referencedColumnName = "id")
	private ExcludedItems excludedItems;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "price")
	private double price;

	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private ListingState listingState;

}
