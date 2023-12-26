package br.com.autopecas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import br.com.autopecas.form.LojaForm;

@Component
@Entity
public class Loja extends Empresa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Loja() {}
	
	public Loja(LojaForm form) {
		
		this.setCelular(form.getCelular());
		this.setCNPJ(form.getCNPJ());
		this.setEmail(form.getEmail());
		this.setEndereco(form.getEndereco());
		this.setNome(form.getNome());
		this.setNomeFantasia(form.getNomeFantasia());
		this.setTelefone(form.getTelefone());
		this.setPeca(form.getPecas());
		this.setProduto(form.getProdutos());
		
	}
	
	@OneToMany(mappedBy = "loja")
	private List<Peca> pecas;
	
	@OneToMany(mappedBy = "loja")
	private List<Produto> produtos;
	
	public List<Peca> getPecas() {
		return pecas;
	}
	public void setPeca(List<Peca> pecas) {
		this.pecas = pecas;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProduto(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}