package br.com.autopecas.form;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.autopecas.modelo.Servico;

@Component
public class OficinaForm extends EmpresaForm {

	private List<Servico> servicos;
	
	public List<Servico> getServicos() {
		return this.servicos;
	}
	
	public void setServicos (List<Servico> servicos) {
		this.servicos = servicos;
	}
}
