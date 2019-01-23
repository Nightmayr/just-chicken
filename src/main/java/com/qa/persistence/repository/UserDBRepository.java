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

import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

	@Transactional(SUPPORTS)
	@Default
	public class UserDBRepository implements UserRepository{
		
		@PersistenceContext(unitName = "primary")
		private EntityManager manager;
		
		@Inject
		private JSONUtil util;
		
		public String getAllUsers() {
			Query query = manager.createQuery("SELECT u FROM User u");
			Collection<User> users = (Collection<User>)query.getResultList();
			return util.getJSONForObject(users);
		}
		
		@Transactional(REQUIRED)
		public String addUser(String user) {
			User aUser = util.getObjectForJSON(user, User.class) ;
			manager.persist(aUser);
			return "{\"message\": \"User sucessfully added\"}";
		}
		
		@Transactional(REQUIRED)
		public String deleteUser(Long id) {
			User user = findUser(id);
			manager.remove(user);
			return "{\"message\": \"User sucessfully deleted\"}";
		}
		
//		@Override
		@Transactional(REQUIRED)
		public String updateUser(Long id, String user) {
			User foundUser = findUser(id);
			User jsonUser = util.getObjectForJSON(user, User.class);
			if(foundUser!=null) {
				manager.remove(foundUser);
				manager.persist(jsonUser);
				return "{\"message\": \"User sucessfully updated\"}";
			}
			return null;
		}
		
		private User findUser(Long id) {
			return manager.find(User.class, id);
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

