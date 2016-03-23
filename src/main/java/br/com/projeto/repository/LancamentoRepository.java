package br.com.projeto.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.projeto.entity.ContaBancaria;
import br.com.projeto.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	@Query("Select l from Lancamento l where l.contaBancaria.usuario.id = :id")
	List<Lancamento> findByUsuario(@Param("id") Long id);
	
	
	@Query("Select l from Lancamento l where l.data between :dataInicio and :dataFim")
	List<Lancamento> findByData(@Param("dataInicio") String dataInicio,@Param("dataFim") String dataFim);
	
	
/*	SELECT ...
	FROM LANCAMENTO
	WHERE
		( FILTER(lancamento.nome = :filter) )
		and lancamento.data > Cast as date :dataInicio OR :dataInicio = NULL */
	/*List<Lancamento> listLancamentosByFilters(@Param("filtro") String filtro, @Param("dataInicio") Calendar dataInicio,)*/
}
