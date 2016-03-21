package br.com.projeto.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.net.jsse.openssl.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.xpath.internal.operations.Bool;

import br.com.projeto.entity.Usuario;
import br.com.projeto.entity.UsuarioLogado;
import br.com.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario save(Usuario usuario)
	{
		String hash = new BCryptPasswordEncoder().encode(usuario.getPassword());
		usuario.setPassword(hash);
		return repository.save(usuario);
	}
	
	public List<Usuario> findAll(SecurityContextHolderAwareRequestWrapper request)
	{
		boolean roleAdministrador = request.isUserInRole("ROLE_ADMINISTRADOR");
		if(roleAdministrador == true)
		{
			return repository.findAll();	
		}
		else
		{
			UsuarioLogado user = (UsuarioLogado)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Usuario usuario = repository.findByEmail(user.getUsername());
			List<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios.add(usuario);
			return usuarios;
		}
				
	}
	
	public Usuario findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Usuario findById(Long id) {
		return repository.findOne(id);
	}
	
	public void deleteUsuario(Long id){
		repository.delete(id);
	}
	
	public void updateUser(Boolean situacao, Long id) {
		repository.changeSituacao(situacao, id);
	}
	
	public Usuario updateUsuario(Usuario usuario) {
		String novoPassword = usuario.getPasswordEdit();
		if(novoPassword != null && !novoPassword.isEmpty()){
			String hash = new BCryptPasswordEncoder().encode(usuario.getPasswordEdit());
			usuario.setPassword(hash);	
		}
		return repository.save(usuario);
	}
	
}
