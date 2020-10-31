package irving.apirest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import irving.apirest.entity.User;

@Repository
public class UserDAOlmpl implements UserDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<User> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		System.out.print("el query"+theQuery);
		List<User> users = theQuery.getResultList();
		
		return users;

	}

	@Override
	public User findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		User user = currentSession.get(User.class, id);
		
		return user;
	}

	@Override
	@Transactional
	public 	User save(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(user);
		return user;
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<User> theQuery = currentSession.createQuery("delete from User where id=:idUser");
		
		theQuery.setParameter("idUser", id);
		theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public User findByEmail(String mail) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);

		User user = currentSession.get(User.class, mail);
		System.out.print("dfdsfds"+user);
		return user;
	}

	
}