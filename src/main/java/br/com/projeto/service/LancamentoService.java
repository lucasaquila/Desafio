package br.com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Service;

import br.com.projeto.entity.ContaBancaria;
import br.com.projeto.entity.Lancamento;
import br.com.projeto.entity.UsuarioLogado;
import br.com.projeto.repository.ContaBancariaRepository;
import br.com.projeto.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;
	
	public List<Lancamento> findAll(SecurityContextHolderAwareRequestWrapper request){
		
		boolean roleAdministrador = request.isUserInRole("ROLE_ADMINISTRADOR");
		if(roleAdministrador == true)
		{
			return repository.findAll();	
		}
		else
		{
			UsuarioLogado user = (UsuarioLogado)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			return repository.findByUsuario(user.getId());
		}
	}
	
}
