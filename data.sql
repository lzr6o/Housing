INSERT INTO `housing`.`address` (`id`, `address_line_1`, `city`, `state`, `zip`) VALUES ('1', '1234 7 St', 'San Diego', 'California', '92103');
INSERT INTO `housing`.`address` (`id`, `address_line_1`, `city`, `state`, `zip`) VALUES ('4', '500 1st St', 'Chula Vista', 'California', '91910');
INSERT INTO `housing`.`address` (`id`, `address_line_1`, `city`, `state`, `zip`) VALUES ('5', '503 1st St', 'Chula Vista', 'California', '91910');
INSERT INTO `housing`.`address` (`id`, `address_line_1`, `city`, `state`, `zip`) VALUES ('2', '555 Highland Ave', 'National City', 'California', '91950');
INSERT INTO `housing`.`address` (`id`, `address_line_1`, `city`, `state`, `zip`) VALUES ('3', '123 E St', 'Chula Vista', 'California', '91910');

INSERT INTO `housing`.`user` (`id`, `email`, `first_name`, `last_name`, `status`) VALUES ('1', 'abc@gmail.com', 'Lokesh', 'Gupta', 'ACTIVE');
INSERT INTO `housing`.`user` (`id`, `email`, `first_name`, `last_name`, `status`) VALUES ('2', 'xyz@email.com', 'Deja', 'Vu', 'ACTIVE');
INSERT INTO `housing`.`user` (`id`, `email`, `first_name`, `last_name`, `status`) VALUES ('3', 'cap@marvel.com', 'Captain', 'America', 'ACTIVE');
INSERT INTO `housing`.`user` (`id`, `email`, `first_name`, `last_name`, `status`) VALUES ('4', 'tony@marvel.com', 'Tony', 'Stark', 'PENDING');

INSERT INTO `housing`.`primary_owner` (`id`, `user_id`) VALUES ('1', '1');
INSERT INTO `housing`.`primary_owner` (`id`, `user_id`) VALUES ('2', '3');
INSERT INTO `housing`.`primary_owner` (`id`, `user_id`) VALUES ('3', '4');

INSERT INTO `housing`.`property` (`id`, `description`, `number_baths`, `number_bedrooms`, `owner_type`, `primary_image_url`, `property_type`, `square_feet`, `address_id`, `primary_owner_id`) VALUES ('1', 'Beautiful country home', '3', '4', 'Individual', 'https://d1xpwittheih7o.cloudfront.net/images/67/CaminitoDePizza.jpg', 'SingleFamilyHome', '2000', '1', '1');
INSERT INTO `housing`.`property` (`id`, `description`, `number_baths`, `number_bedrooms`, `owner_type`, `primary_image_url`, `property_type`, `square_feet`, `address_id`, `primary_owner_id`) VALUES ('2', 'Beautiful city home', '2', '3', 'Individual', 'https://d1xpwittheih7o.cloudfront.net/images/112/listing-34846a83-d5e3-40ce-aa2d-542d1d24cfde-018_10818%20Aderman%20Ave%20Unit%20121_20220419.jpg', 'SingleFamilyHome', '1200', '2', '2');
INSERT INTO `housing`.`property` (`id`, `description`, `number_baths`, `number_bedrooms`, `owner_type`, `primary_image_url`, `property_type`, `square_feet`, `address_id`, `primary_owner_id`) VALUES ('3', 'Big home with great views', '5', '6', 'Individual', 'https://d1xpwittheih7o.cloudfront.net/images/163/listing-34c78d74-c1f9-466f-b844-cb7d8d00e766-842083BA-7E8B-48A2-8E41-0E0CE385DA58.jpeg', 'SingleFamilyHome', '3500', '3', '3');

INSERT INTO `housing`.`excluded_items` (`id`) VALUES ('3');

INSERT INTO `housing`.`included_items` (`id`) VALUES ('1');
INSERT INTO `housing`.`included_items` (`id`) VALUES ('2');

INSERT INTO `housing`.`item` (`id`, `name`, `included_items_id`) VALUES ('1', 'dishwasher', '1');
INSERT INTO `housing`.`item` (`id`, `name`, `included_items_id`) VALUES ('2', 'dryer', '2');
INSERT INTO `housing`.`item` (`id`, `name`, `excluded_items_id`) VALUES ('3', 'washer', '3');

INSERT INTO `housing`.`listing_agent` (`id`, `license_number`, `license_state`, `status`, `user_id`) VALUES ('1', '123456789', 'California', 'ACTIVE', '2');

INSERT INTO `housing`.`escrow_company` (`id`) VALUES ('1');

INSERT INTO `housing`.`title_company` (`id`) VALUES ('2');

INSERT INTO `housing`.`company` (`id`, `type`, `name`, `officer_name`, `address_id`, `escrow_company_id`) VALUES ('1', 'ESCROW', 'Escrow America', 'John Doe', '4', '1');
INSERT INTO `housing`.`company` (`id`, `type`, `name`, `officer_name`, `address_id`, `title_company_id`) VALUES ('2', 'TITLE', 'First American Title', 'George Washington', '5', '2');

INSERT INTO `housing`.`listing` (`id`, `state`, `price`, `escrow_company_id`, `included_items_id`, `listing_agent_id`, `property_id`, `title_company_id`) VALUES ('1', 'PENDING', '649999', '1', '1', '1', '1', '2');
INSERT INTO `housing`.`listing` (`id`, `state`, `price`, `escrow_company_id`, `excluded_items_id`, `included_items_id`, `listing_agent_id`, `property_id`, `title_company_id`) VALUES ('2', 'ACTIVE', '520000', '1', '3', '2', '1', '2', '2');
INSERT INTO `housing`.`listing` (`id`, `state`, `price`, `escrow_company_id`, `listing_agent_id`, `property_id`, `title_company_id`) VALUES ('3', 'PRESALE', '1250000', '1', '1', '3', '2');





USE housing;

SELECT * FROM company;
SELECT * FROM escrow_company;
SELECT * FROM title_company;

SELECT * FROM address;
SELECT * FROM property;
SELECT * FROM primary_owner;
SELECT * FROM user;
SELECT * FROM listing_agent;
SELECT * FROM listing;

SELECT * FROM item;
SELECT * FROM excluded_items;
SELECT * FROM included_items;