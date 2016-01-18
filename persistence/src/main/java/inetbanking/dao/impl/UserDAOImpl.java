package inetbanking.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import inetbanking.dao.UserDAO;
import inetbanking.model.User;

public class UserDAOImpl extends BaseDAO<User,Long> implements UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}

	@Override
	public User getByUsername(String username) {
		
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

		Root<User> root = criteriaQuery.from(User.class);
		Path<String> namePath = root.get("username");
		criteriaQuery.where(builder.equal(namePath, username));

		TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
		List<User> users = typedQuery.getResultList();

		if (users.isEmpty()) {
			return null;
		}

		return users.iterator().next();
	}

}
