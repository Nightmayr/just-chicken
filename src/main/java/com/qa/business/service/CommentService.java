package com.qa.business.service;

public interface CommentService {
	String getAllComments();
	String addComment(String comment);
	String deleteComment(Long id);
	String updateComment(Long id, String comment);
}
