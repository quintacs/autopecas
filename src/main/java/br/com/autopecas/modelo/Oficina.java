package br.com.autopecas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import br.com.autopecas.form.OficinaForm;

@Component
@Entity
public class Oficina extends Empresa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Oficina() {}
	
	public Oficina(OficinaForm form) {
		
		this.setCelular(form.getCelular());
		this.setCNPJ(form.getCNPJ());
		this.setEmail(form.getEmail());
		this.setEndereco(form.getEndereco());
		this.setNome(form.getNome());
		this.setNomeFantasia(form.getNomeFantasia());
		this.setTelefone(form.getTelefone());
		this.setServicos(form.getServicos());
	}
	
	@OneToMany(mappedBy = "oficina")
	private List<Servico> servicos;
	
	public List<Servico> getServicos() {
		return this.servicos;
	}
	
	public void setServicos (List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	
	
}
