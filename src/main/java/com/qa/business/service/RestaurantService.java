package com.qa.business.service;

public interface RestaurantService {
	String getAllRestaurants();
	String addRestaurant(String restaurant);
	String deleteRestaurant(Long id);
	String updateRestaurant(Long id, String restaurant);
	String getRestaurant(Long id);
}
