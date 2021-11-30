package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	Usuario findByEmail(String email);
	Usuario findByNombre(String nombre);
	
	List<Usuario> findAll();
	
	@Query("SELECT u FROM Usuario u")
	List<Usuario> findAllUsuarios();
	
	@Query("SELECT u.nombre FROM Usuario u")
	List<String> findAllUsuariosNombres();
	
	@Query("SELECT u.nombre, u.apellido FROM Usuario u")
	List<Object> findAllUsuariosNombresApellidos();
	
	//Query tradicional, se agrega la tabla, no el objeto
	@Query(value="SELECT nombre, apellido FROM usuarios", nativeQuery=true)
	List<Object> findAllUsuariosNombresApellidosSQL();
	
	@Query("SELECT u FROM Usuario u WHERE id=?1")
	List<Usuario> obtenerUsuarioPorId(Long id);
	
	@Query(value="SELECT * FROM usuarios WHERE id=?1", nativeQuery=true)
	List<Usuario> obtenerUsuarioPorIdSQL(Long id);
}
