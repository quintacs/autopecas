package br.com.autopecas.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.autopecas.modelo.Empresa;
import br.com.autopecas.repository.EmpresaRepository;
import br.com.autopecas.service.EmpresaService;

@Component
@Transactional
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public void save(Empresa empresa) {
		empresaRepository.save(empresa);
	}

	@Override
	public void update(Empresa empresa) {
		
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(empresa.getId());
		if (optionalEmpresa.isPresent()) {
			Empresa vEmpresa = empresaRepository.getOne(empresa.getId());
			vEmpresa.setCelular(empresa.getCelular());
			vEmpresa.setCNPJ(empresa.getCNPJ());
			vEmpresa.setEmail(empresa.getEmail());
			vEmpresa.setEndereco(empresa.getEndereco());
			vEmpresa.setNome(empresa.getNome());
			vEmpresa.setNomeFantasia(empresa.getNomeFantasia());
			vEmpresa.setTelefone(empresa.getTelefone());
			vEmpresa.setUsuario(empresa.getUsuario());
			empresaRepository.save(vEmpresa);
			
			
		}
		

	}

  public boolean atualizar(Empresa empresa) {
		
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(empresa.getId());
		if (optionalEmpresa.isPresent()) {
			Empresa vEmpresa = empresaRepository.getOne(empresa.getId());
			vEmpresa.setCelular(empresa.getCelular());
			vEmpresa.setCNPJ(empresa.getCNPJ());
			vEmpresa.setEmail(empresa.getEmail());
			vEmpresa.setEndereco(empresa.getEndereco());
			vEmpresa.setNome(empresa.getNome());
			vEmpresa.setNomeFantasia(empresa.getNomeFantasia());
			vEmpresa.setTelefone(empresa.getTelefone());
			vEmpresa.setUsuario(empresa.getUsuario());
			empresaRepository.save(vEmpresa);
			
			return true;
		}
		return false;

	}

	@Override
	public void delete(long id) {
		this.empresaRepository.deleteById(id);

	}

	@Override
	public List<Empresa> list() {
		return this.empresaRepository.findAll();
	}

	@Override
	public Empresa findById(long id) {
		
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
		if (optionalEmpresa.isPresent()) {
			return  empresaRepository.getOne(id);
		}
		return null;
	}
}
