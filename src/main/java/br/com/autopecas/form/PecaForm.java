package br.com.autopecas.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class PecaForm {

	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String modelo;
	
	@NotNull @NotEmpty
	private Long ano;
	
	@NotNull @NotEmpty
	private String cor;
	
	@NotNull @NotEmpty
	private String marca;
	
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
