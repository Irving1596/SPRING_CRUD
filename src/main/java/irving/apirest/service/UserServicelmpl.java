package irving.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import irving.apirest.dao.UserDAO;
import irving.apirest.entity.User;

@Service
public class UserServicelmpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> findAll() {
		List<User> listUsers= userDAO.findAll();
		return listUsers;
	}

	@Override
	public User findById(int id) {
		User user = userDAO.findById(id);
		return user;
	}

	@Override
	public User save(User user) {
		userDAO.save(user);
		return user;

	}

	@Override
	public int deleteById(int id) {
		userDAO.deleteById(id);
		return id;
	}



}