package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Restaurant;
import com.qa.persistence.repository.RestaurantRepository;
import com.qa.util.JSONUtil;

public class RestaurantServiceImplementation implements RestaurantService {

	@Inject
	private RestaurantRepository repo;
	@Inject
	private JSONUtil util;
	
	
	public String getAllRestaurants() {
		return repo.getAllRestaurants();
	}

	public String addRestaurant(String restaurant) {
		Restaurant checkRestaurant = util.getObjectForJSON(restaurant, Restaurant.class);
		return repo.addRestaurant(restaurant);
	}

	public String deleteRestaurant(Long id) {
		return repo.deleteRestaurant(id);
	}

	public String updateRestaurant(Long id, String restaurant) {
		return repo.updateRestaurant(id, restaurant);
	}
	
}
