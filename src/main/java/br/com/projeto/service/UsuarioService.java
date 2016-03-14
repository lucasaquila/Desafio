package br.com.projeto.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.entity.Usuario;
import br.com.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario save(Usuario usuario)
	{
//		usuario.setSituacao(true);
		String hash = new BCryptPasswordEncoder().encode(usuario.getPassword());
		usuario.setPassword(hash);
		return repository.save(usuario);
	}
	
	public List<Usuario> findAll()
	{
		return repository.findAll();		
	}
	
	public Usuario findByEmail(String email) {
		return repository.finByEmail(email);
	}
	
}
