package br.com.autopecas.dto;

import br.com.autopecas.modelo.Peca;

public class PecaDto {

	private Long id;
	private String nome;
	private String modelo;
	private Long ano;
	private String cor;
	private String marca;
	
	public PecaDto(Peca peca) {
		this.id = peca.getId();
		this.nome = peca.getNome();
		this.modelo = peca.getModelo();
		this.ano = peca.getAno();
		this.cor = peca.getCor();
		this.marca = peca.getMarca();
	}

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
}
