package br.com.autopecas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import br.com.autopecas.form.ProdutoForm;

@Component
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String marca;
	private String descricao;
	
	public Produto() {}
	
	public Produto(ProdutoForm form) {
		this.nome = form.getNome();
		this.marca = form.getMarca();
		this.descricao = form.getDescricao();
	}
	
	@ManyToOne
	private Loja loja;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLojas(Loja loja) {
		this.loja = loja;
	}
	
	
	
}
