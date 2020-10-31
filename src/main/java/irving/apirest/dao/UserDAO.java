package irving.apirest.dao;

import java.util.List;

import irving.apirest.entity.User;


public interface UserDAO {
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public User findByEmail(String mail);
	
	public User save(User user);
	
	public void deleteById(int id);
}