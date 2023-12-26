package br.com.autopecas.dto;

import br.com.autopecas.modelo.Empresa;

public class OficinaDto {

	private Empresa empresa;
	
	public OficinaDto(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
}
