package br.com.autopecas.dto;

import br.com.autopecas.modelo.Usuario;

public class UsuarioDto {

	private Long idUsuario;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String celular;
	private String email;
	
	public UsuarioDto(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.endereco = usuario.getEndereco();
		this.telefone = usuario.getTelefone();
		this.celular = usuario.getCelular();
		this.email = usuario.getEmail();
	}
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
