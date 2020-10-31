package irving.apirest.repository;



import org.springframework.data.jpa.repository.JpaRepository;



import irving.apirest.entity.Usuarios;


public interface IUserRepository extends JpaRepository<Usuarios, Integer> {

	Usuarios findByNombre(String nombre);
}
