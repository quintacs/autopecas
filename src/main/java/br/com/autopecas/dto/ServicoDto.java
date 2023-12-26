package br.com.autopecas.dto;

import br.com.autopecas.modelo.Servico;

public class ServicoDto {

	private long id;
	private String nome;
	private String descricao;
	
	public ServicoDto(Servico servico) {
		this.id = servico.getId();
		this.nome = servico.getNome();
		this.descricao = servico.getDescricao();
	}
	
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
	
	
}
