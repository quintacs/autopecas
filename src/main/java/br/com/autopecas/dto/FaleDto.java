package br.com.autopecas.dto;

import br.com.autopecas.modelo.FaleConosco;

public class FaleDto {

	private Long id;
	private String nome;
	private String email;
	private String mensagem;
	
	public FaleDto(FaleConosco fale) {
		this.id = fale.getId();
		this.nome = fale.getNome();
		this.email = fale.getEmail();
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
