package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Comment;
import com.qa.persistence.repository.CommentRepository;
import com.qa.util.JSONUtil;

public class CommentServiceImplementation implements CommentService {

	@Inject
	private CommentRepository repo;
	@Inject
	private JSONUtil util;
	
	
	public String getAllComments() {
		return repo.getAllComments();
	}

	public String addComment(String comment) {
		Comment checkComment = util.getObjectForJSON(comment, Comment.class);
		return repo.addComment(comment);
	}

	public String deleteComment(Long id) {
		return repo.deleteComment(id);
	}

	public String updateComment(Long id, String comment) {
		return repo.updateComment(id, comment);
	}
	
}