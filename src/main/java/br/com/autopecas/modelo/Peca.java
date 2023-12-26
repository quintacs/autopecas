package br.com.autopecas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import br.com.autopecas.form.PecaForm;


@Component
@Entity
public class Peca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String modelo;
	private Long ano;
	private String cor;
	private String marca;
	
	public Peca() {}
	
	public Peca(PecaForm form) {
		
		this.nome = form.getNome();
		this.modelo = form.getModelo();
		this.ano = form.getAno();
		this.cor = form.getCor();
		this.marca = form.getMarca();
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Long getAno() {
		return ano;
	}
	public void setAno(Long ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLojas(Loja loja) {
		this.loja = loja;
	}

	
}
