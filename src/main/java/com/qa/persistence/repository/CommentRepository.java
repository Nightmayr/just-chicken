package com.qa.persistence.repository;

public interface CommentRepository {
	
	String getAllComments();
	String addComment(String comment);
	String deleteComment(Long id);
	String updateComment(Long id, String comment);
}
