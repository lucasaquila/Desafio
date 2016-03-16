package br.com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.entity.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long>{

}
