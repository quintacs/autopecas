package br.com.autopecas.dto;

import br.com.autopecas.modelo.Empresa;

public class LojaDto {

	private Empresa empresa;
	
	public LojaDto(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
}
