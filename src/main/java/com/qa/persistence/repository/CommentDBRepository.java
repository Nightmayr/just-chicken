
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

import com.qa.persistence.domain.Comment;
import com.qa.util.JSONUtil;

	@Transactional(SUPPORTS)
	@Default
	public class CommentDBRepository implements CommentRepository{
		
		@PersistenceContext(unitName = "primary")
		private EntityManager manager;
		
		@Inject
		private JSONUtil util;
		
		public String getAllComments() {
			Query query = manager.createQuery("SELECT c FROM Comment c");
			Collection<Comment> comments = (Collection<Comment>)query.getResultList();
			return util.getJSONForObject(comments);
		}
		
		@Transactional(REQUIRED)
		public String addComment(String comment) {
			Comment aComment = util.getObjectForJSON(comment, Comment.class) ;
			manager.persist(aComment);
			return "{\"message\": \"Comment sucessfully added\"}";
		}
		
		@Transactional(REQUIRED)
		public String deleteComment(Long id) {
			Comment comment = findComment(id);
			manager.remove(comment);
			return "{\"message\": \"Comment sucessfully deleted\"}";
		}
		
//		@Override
		@Transactional(REQUIRED)
		public String updateComment(Long id, String comment) {
			Comment foundComment = findComment(id);
			Comment jsonComment = util.getObjectForJSON(comment, Comment.class);
			if(foundComment!=null) {
				manager.remove(foundComment);
				manager.persist(jsonComment);
				return "{\"message\": \"Comment sucessfully updated\"}";
			}
			return null;
		}
		
		private Comment findComment(Long id) {
			return manager.find(Comment.class, id);
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
