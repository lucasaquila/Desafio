package br.com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.entity.ContaBancaria;
import br.com.projeto.repository.ContaBancariaRepository;

@Service
public class ContaBancariaService {
	
	@Autowired
	private ContaBancariaRepository repository;
	
	public ContaBancaria findById(Long id)
	{
		return repository.findOne(id);
	}
	
	public List<ContaBancaria> findAll(){
		return repository.findAll();
	}
	
	public ContaBancaria save(ContaBancaria contaBancaria){
		return repository.save(contaBancaria);
	}
}
