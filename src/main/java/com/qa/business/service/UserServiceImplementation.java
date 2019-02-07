package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserRepository;
import com.qa.util.JSONUtil;

public class UserServiceImplementation implements UserService {

	@Inject
	private UserRepository repo;
	@Inject
	private JSONUtil util;
	
	String[] restrictedWords = new String[] {"idiot", "stupid" };
	
	
	public String getAllUsers() {
		return repo.getAllUsers();
	}

	public String addUser(String user) {
		User checkUser = util.getObjectForJSON(user, User.class);
		String numRegex   = ".*[0-9].*";
		String alphaRegex = ".*[A-Z].*";

		for(int i=0; i<restrictedWords.length;i++) {
			if(checkUser.getUsername().equals(restrictedWords[i])) {
				return "Username invalid!";
			} else if(checkUser.getUsername().length()<5 || checkUser.getUsername().length()>15) {
				return "Username should be between 5 and 15 characters";
			} else {
				if(!(checkUser.getPassword().matches(numRegex) && checkUser.getPassword().matches(alphaRegex))){
					return "Password should contain letters and numbers";
				} else if(checkUser.getPassword().length()<5 || checkUser.getPassword().length()>15) {
					return "Password should be between 5 and 15 characters";
				}
			}
		}
		return repo.addUser(user);
	}

	public String deleteUser(Long id) {
		return repo.deleteUser(id);
	}

	public String updateUser(Long id, String user) {
		return repo.updateUser(id, user);
	}
	
}