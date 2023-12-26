package br.com.autopecas.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.autopecas.modelo.Oficina;
import br.com.autopecas.repository.OficinaRepository;
import br.com.autopecas.service.OficinaService;

@Component
@Transactional
public class OficinaServiceImpl implements OficinaService {

	@Autowired
	OficinaRepository oficinaRepository;
	
	@Override
	public void save(Oficina oficina) {
		oficinaRepository.save(oficina);
	}

	@Override
	public void update(Oficina oficina) {
		
		Optional<Oficina> optionalOficina = oficinaRepository.findById(oficina.getId());
		if (optionalOficina.isPresent()) {
			Oficina vOficina = oficinaRepository.getOne(oficina.getId());
			vOficina.setCelular(oficina.getCelular());
			vOficina.setCNPJ(oficina.getCNPJ());
			vOficina.setEmail(oficina.getEmail());
			vOficina.setEndereco(oficina.getEndereco());
			vOficina.setNome(oficina.getNome());
			vOficina.setNomeFantasia(oficina.getNomeFantasia());
			vOficina.setServicos(oficina.getServicos());
			vOficina.setTelefone(oficina.getTelefone());
			vOficina.setUsuario(oficina.getUsuario());
			oficinaRepository.save(vOficina);
			
			
		}
		

	}


	@Override
	public void delete(long id) {
		this.oficinaRepository.deleteById(id);

	}

	@Override
	public List<Oficina> list() {
		return this.oficinaRepository.findAll();
	}

	@Override
	public Oficina findById(long id) {
		Optional<Oficina> optionalOficina = oficinaRepository.findById(id);
		if (optionalOficina.isPresent()) {
			return  oficinaRepository.getOne(id);
		}
		return null;
	}

	@Override
	public boolean atualizar(Oficina oficina) {
		 Optional<Oficina> optionalOficina = oficinaRepository.findById(oficina.getId());
			if (optionalOficina.isPresent()) {
				Oficina vOficina = oficinaRepository.getOne(oficina.getId());
				vOficina.setCelular(oficina.getCelular());
				vOficina.setCNPJ(oficina.getCNPJ());
				vOficina.setEmail(oficina.getEmail());
				vOficina.setEndereco(oficina.getEndereco());
				vOficina.setNome(oficina.getNome());
				vOficina.setNomeFantasia(oficina.getNomeFantasia());
				vOficina.setTelefone(oficina.getTelefone());
				vOficina.setUsuario(oficina.getUsuario());
				oficinaRepository.save(vOficina);
				
				return true;
			}
		return false;
	}

}
