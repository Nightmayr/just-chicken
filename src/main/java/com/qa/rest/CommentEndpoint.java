package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.CommentService;

@Path("/comment")
public class CommentEndpoint {
	
	@Inject
	private CommentService service;
	
	@Path("getAllComments")
	@GET
	@Produces({"application/json"})
	public String getAllComments() {
		return service.getAllComments();
	}
	
	@Path("/addComment")
	@POST
	@Produces({"application/json"})
	public String addComment(String comment) {
		return service.addComment(comment);
	}
	
	@Path("/updateComment/{id}")
	@PUT
	@Produces({"application/json"})
	public String upddateComment(@PathParam("id") Long id, String comment) {
		return service.updateComment(id, comment);
	}
	
	@Path("/deleteComment/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteComment(@PathParam("id") Long id) {
		return service.deleteComment(id);
	}
	
	public void setService(CommentService service) {
		this.service = service;
	}
	
}
