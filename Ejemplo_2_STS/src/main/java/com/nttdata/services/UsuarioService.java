package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nttdata.models.Role;
import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder bcpe;

	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public void persistirUsuarioRol(Usuario usuario) {
		List<Role> roles=roleService.buscaRolPorNombre("ROLE_USER");
		String encode=bcpe.encode(usuario.getPassword());
		String hashpw=BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		System.out.println("Password: "+usuario.getPassword());
		System.out.println("Encode: "+encode);
		System.out.println("Hashpw: "+hashpw);
		
		if(!encode.equals(hashpw)) {
			System.out.println("Códigos distintos");
		}
		
		if(BCrypt.checkpw(usuario.getPassword(), encode)) {
			System.out.println("checkpw devuelve true en encode");
		}
		
		if(BCrypt.checkpw(usuario.getPassword(), hashpw)) {
			System.out.println("checkpw devuelve true en hashpw");
		}
		
		usuario.setPassword(bcpe.encode(usuario.getPassword()));
		usuario.setRoles(roleService.buscaRolPorNombre("ROLE_USER"));
		
		System.out.println("rol:"+roles.get(0).getId());
		System.out.println("nombre: "+roles.get(0).getNombre());
		
		usuarioRepository.save(usuario);
	}
	
	public Usuario registroUsuario(Usuario usuario) {
		//Encriptar password de usuario
		String password_hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(password_hashed);
		return usuarioRepository.save(usuario);
	}
	
	public void insertarUsuario(@Valid Usuario usuario) {
		
		usuarioRepository.save(usuario);
	}
	public List<Usuario> obtenerListaUsuarios() {
		return usuarioRepository.findAllUsuarios();
	}
	
	public List<String> obtenerNombresUsuarios(){
		return usuarioRepository.findAllUsuariosNombres();
	}
	
	public List<Object> obtenerNombresApellidosUsuarios(){
		return usuarioRepository.findAllUsuariosNombresApellidos();
	}
	
	public Usuario encontrarUsuario(Long id) {
		return usuarioRepository.findById(id).get();
	}
	public void eliminarUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	public boolean loginUsuario(String email, String password) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if(usuario==null) {
			return false;
			//revisa la password, primero el password string y luego el encriptado
		}else if(BCrypt.checkpw(password, usuario.getPassword())){
			return true;
		}else {
			return false;
		}
	}

	public Usuario findByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}
}
