package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.RestaurantService;

@Path("/restaurant")
public class RestaurantEndpoint {
	
	@Inject
	private RestaurantService service;
	
	@Path("getAllRestaurants")
	@GET
	@Produces({"application/json"})
	public String getAllRestaurants() {
		return service.getAllRestaurants();
	}
	
	@Path("/addRestaurant")
	@POST
	@Produces({"application/json"})
	public String addRestaurant(String restaurant) {
		return service.addRestaurant(restaurant);
	}
	
	@Path("/updateRestaurant/{id}")
	@PUT
	@Produces({"application/json"})
	public String upddateRestaurant(@PathParam("id") Long id, String restaurant) {
		return service.updateRestaurant(id, restaurant);
	}
	
	@Path("/deleteRestaurant/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteRestaurant(@PathParam("id") Long id) {
		return service.deleteRestaurant(id);
	}
	
	public void setService(RestaurantService service) {
		this.service = service;
	}
	
}
