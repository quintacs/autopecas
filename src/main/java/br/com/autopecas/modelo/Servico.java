package br.com.autopecas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import br.com.autopecas.form.ServicoForm;

@Component
@Entity
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	
	public Servico() {}
	
	public Servico(ServicoForm form) {
		this.nome = form.getNome();
		this.descricao = form.getDescricao();
	}
	
	@ManyToOne
	private Oficina oficina;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Oficina getOficina() {
		return oficina;
	}
	public void setOficinas(Oficina oficina) {
		this.oficina = oficina;
	}
	
}