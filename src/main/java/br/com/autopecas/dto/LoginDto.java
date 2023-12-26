package br.com.autopecas.dto;

import br.com.autopecas.modelo.Login;

public class LoginDto {

	private Long id;
	private String email;
	private String senha;
	private String nome;
	
	public LoginDto(Login login) {
		this.id = login.getId();
		this.email = login.getEmail();
		this.senha = login.getSenha();
		this.nome = login.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
