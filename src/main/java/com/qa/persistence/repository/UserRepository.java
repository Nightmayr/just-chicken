package com.qa.persistence.repository;

public interface UserRepository {
	
	String getAllUsers();
	String addUser(String user);
	String deleteUser(Long id);
	String updateUser(Long id, String user);
}
