package com.qa.repository;

public interface RestaurantRepository {
	
	String getAllRestaurants();
	String addRestaurant(String restaurant);
	String deleteRestaurant(Long id);
	String updateRestaurant(Long id, String restaurant);

}
