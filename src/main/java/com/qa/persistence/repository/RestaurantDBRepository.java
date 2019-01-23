package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Restaurant;
import com.qa.util.JSONUtil;

	@Transactional(SUPPORTS)
	@Default
	public class RestaurantDBRepository implements RestaurantRepository{
		
		@PersistenceContext(unitName = "primary")
		private EntityManager manager;
		
		@Inject
		private JSONUtil util;
		
		public String getAllRestaurants() {
			Query query = manager.createQuery("SELECT r FROM Restaurant r");
			Collection<Restaurant> restaurants = (Collection<Restaurant>)query.getResultList();
			return util.getJSONForObject(restaurants);
		}
		
		@Transactional(REQUIRED)
		public String addRestaurant(String restaurant) {
			Restaurant aRestaurant = util.getObjectForJSON(restaurant, Restaurant.class) ;
			manager.persist(aRestaurant);
			return "{\"message\": \"Restaurant sucessfully added\"}";
		}
		
		@Transactional(REQUIRED)
		public String deleteRestaurant(Long id) {
			Restaurant restaurant = findRestaurant(id);
			manager.remove(restaurant);
			return "{\"message\": \"Restaurant sucessfully deleted\"}";
		}
		
//		@Override
		@Transactional(REQUIRED)
		public String updateRestaurant(Long id, String restaurant) {
			Restaurant foundRestaurant = findRestaurant(id);
			Restaurant jsonRestaurant = util.getObjectForJSON(restaurant, Restaurant.class);
			if(foundRestaurant!=null) {
				manager.remove(foundRestaurant);
				manager.persist(jsonRestaurant);
				return "{\"message\": \"Restaurant sucessfully updated\"}";
			}
			return null;
		}
		
		private Restaurant findRestaurant(Long id) {
			return manager.find(Restaurant.class, id);
		}
		
		public EntityManager getManager() {
			return manager;
		}

		public void setManager(EntityManager manager) {
			this.manager = manager;
		}

		public JSONUtil getUtil() {
			return util;
		}

		public void setUtil(JSONUtil util) {
			this.util = util;
		}
		

}
