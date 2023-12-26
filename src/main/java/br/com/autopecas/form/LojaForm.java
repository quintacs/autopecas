package br.com.autopecas.form;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.autopecas.modelo.Peca;
import br.com.autopecas.modelo.Produto;

@Component
public class LojaForm extends EmpresaForm {

	private List<Peca> pecas;
	
	private List<Produto> produtos;
	
	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	
}
