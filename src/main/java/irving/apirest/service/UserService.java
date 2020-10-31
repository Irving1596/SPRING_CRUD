package irving.apirest.service;

import java.util.List;

import irving.apirest.entity.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public User save(User user);
	
	public int deleteById(int id);
	

}