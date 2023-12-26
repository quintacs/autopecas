package br.com.autopecas.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.autopecas.modelo.Loja;
import br.com.autopecas.repository.LojaRepository;
import br.com.autopecas.service.LojaService;

@Component
@Transactional
public class LojaServiceImpl implements LojaService{

	@Autowired
	LojaRepository lojaRepository;
	
	@Override
	public void save(Loja loja) {
		lojaRepository.save(loja);
	}

	@Override
	public void update(Loja loja) {
		
		Optional<Loja> optionalLoja = lojaRepository.findById(loja.getId());
		if (optionalLoja.isPresent()) {
			Loja vLoja = lojaRepository.getOne(loja.getId());
			vLoja.setCelular(loja.getCelular());
			vLoja.setCNPJ(loja.getCNPJ());
			vLoja.setEmail(loja.getEmail());
			vLoja.setEndereco(loja.getEndereco());
			vLoja.setNome(loja.getNome());
			vLoja.setNomeFantasia(loja.getNomeFantasia());
			vLoja.setPeca(loja.getPecas());
			vLoja.setProduto(loja.getProdutos());
			vLoja.setTelefone(loja.getTelefone());
			vLoja.setUsuario(loja.getUsuario());
			lojaRepository.save(vLoja);
			
			
		}
		

	}


	@Override
	public void delete(long id) {
		this.lojaRepository.deleteById(id);

	}

	@Override
	public List<Loja> list() {
		return this.lojaRepository.findAll();
	}

	@Override
	public Loja findById(long id) {
		Optional<Loja> optionalLoja = lojaRepository.findById(id);
		if (optionalLoja.isPresent()) {
			return  lojaRepository.getOne(id);
		}
		return null;
	}

	@Override
	public boolean atualizar(Loja loja) {
		 Optional<Loja> optionalLoja = lojaRepository.findById(loja.getId());
		if (optionalLoja.isPresent()) {
			Loja vLoja = lojaRepository.getOne(loja.getId());
			vLoja.setCelular(loja.getCelular());
			vLoja.setCNPJ(loja.getCNPJ());
			vLoja.setEmail(loja.getEmail());
			vLoja.setEndereco(loja.getEndereco());
			vLoja.setNome(loja.getNome());
			vLoja.setNomeFantasia(loja.getNomeFantasia());
			vLoja.setTelefone(loja.getTelefone());
			vLoja.setUsuario(loja.getUsuario());
			lojaRepository.save(vLoja);
			
			return true;
		}
		return false;
	}

}
