package br.com.projeto.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private LancamentoRepository lancamentoRepository;
	
	@Autowired 
	private ContaBancariaRepository contaBancariaRepository; 
	
	public List<Lancamento> findAll(SecurityContextHolderAwareRequestWrapper request){
		
		boolean roleAdministrador = request.isUserInRole("ROLE_ADMINISTRADOR");
		if(roleAdministrador == true)
		{
			return lancamentoRepository.findAll();	
		}
		else
		{
			UsuarioLogado user = (UsuarioLogado)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			return lancamentoRepository.findByUsuario(user.getId());
		}
	}
	
	public Lancamento efetuarDeposito(Lancamento lancamento){
		Long id = lancamento.getContaBancaria().getId();
		ContaBancaria contaBancaria = contaBancariaRepository.findOne(id);
		BigDecimal saldoAtual = contaBancaria.getSaldo().add(lancamento.getValor());
		contaBancaria.setSaldo(saldoAtual);
		contaBancariaRepository.save(contaBancaria);
		return lancamentoRepository.save(lancamento);
	}
	
	public ResponseEntity<Lancamento> efetuarSaque(Lancamento lancamento){
		Long id = lancamento.getContaBancaria().getId();
		ContaBancaria contaBancaria = contaBancariaRepository.findOne(id);
		

		BigDecimal saldoAtual = contaBancaria.getSaldo().subtract(lancamento.getValor());
		if(saldoAtual.signum() == -1){
	          return new ResponseEntity<Lancamento>(HttpStatus.CONFLICT);//You many decide to return HttpStatus.NOT_FOUND
	    }

		contaBancaria.setSaldo(saldoAtual);
		contaBancariaRepository.save(contaBancaria);
		/*return lancamentoRepository.save(lancamento);*/
        return new ResponseEntity<Lancamento>(lancamento, HttpStatus.OK);
	}

	
}
