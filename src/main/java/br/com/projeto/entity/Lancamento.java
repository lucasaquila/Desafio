package br.com.projeto.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.sun.istack.internal.NotNull;
import com.sun.javafx.scene.control.skin.FXVK.Type;

@Entity
@Table(name = "lancamento")
public class Lancamento extends AbstractPersistable<Long>{
	
	private String observacao;
	
	@NotNull
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name="id_contabancaria")
	private ContaBancaria contaBancaria;
	
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipoLancamento;

	private LocalDate data;
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	@Override
	protected void setId(Long id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}
	
	
	
	

}
