package br.com.projeto.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.projeto.entity.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long>{

	@Modifying(clearAutomatically = true)
	@Query("update ContaBancaria c set c.saldo =:saldo where c.id =:id")
	void inserirSaldoInicial(@Param("id") Long id,@Param("saldo") BigDecimal saldo);
	
	
}
