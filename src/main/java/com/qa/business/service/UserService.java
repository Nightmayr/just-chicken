package com.qa.business.service;

public interface UserService {
	String getAllUsers();
	String addUser(String user);
	String deleteUser(Long id);
	String updateUser(Long id, String user);
}
