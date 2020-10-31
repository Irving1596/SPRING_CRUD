package irving.apirest;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import irving.apirest.repository.IUserRepository;

import irving.apirest.entity.Usuarios;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApirestApplicationTests {

//	@Autowired
//	private UserService userService;
	
	@Autowired
	private IUserRepository repo;
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	@Test
	void crearUsuarioTest() {
		Usuarios us=new Usuarios();
	
		us.setNombre("Diego");
		us.setClave(encoder.encode("123456"));
		//us.setPassword(encoder.encode("123456"));
		Usuarios retorno = repo.save(us);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
		
		//int id=userService.deleteById(4);
		//assertTrue(id==4);
		
		//User usmail=new User();
		//User retorno = userRepo.findByEmail("jose");
	//	assertTrue(retorno.getEmail().equalsIgnoreCase("jose"));

	}

}
