package br.com.autopecas.dto;

import br.com.autopecas.modelo.Empresa;

public class EmpresaDto {

	private Long id;
	private String nome;
	private String nomeFantasia;
	private String CNPJ;	
	private String telefone;
	private String celular;
	private String email;	
	private String endereco;
	
	public EmpresaDto(Empresa empresa) {
		this.id = empresa.getId();
		this.nome = empresa.getNome();
		this.nomeFantasia = empresa.getNomeFantasia();
		this.CNPJ = empresa.getCNPJ();
		this.telefone = empresa.getTelefone();
		this.celular = empresa.getCelular();
		this.email = empresa.getEmail();
		this.endereco = empresa.getEndereco();
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

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
