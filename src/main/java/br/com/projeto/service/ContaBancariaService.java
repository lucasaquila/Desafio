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
	
	public List<ContaBancaria> findAll(){
		return repository.findAll();
	}
}
