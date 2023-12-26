package br.com.autopecas.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.autopecas.modelo.FaleConosco;
import br.com.autopecas.repository.FaleConoscoRepository;
import br.com.autopecas.service.FaleConoscoService;

@Component
@Transactional
public class FaleConoscoImpl implements FaleConoscoService {
	
	@Autowired
	private FaleConoscoRepository faleConoscoRepository;
	
	@Override
	public void save(FaleConosco faleConosco) {
		faleConoscoRepository.save(faleConosco);
	}

	@Override
	public void update(FaleConosco faleConosco) {
		
		Optional<FaleConosco> optionalFaleConosco = faleConoscoRepository.findById(faleConosco.getId());
		if (optionalFaleConosco.isPresent()) {
			FaleConosco vFaleConosco = faleConoscoRepository.getOne(faleConosco.getId());
			vFaleConosco.setEmail(faleConosco.getEmail());
			vFaleConosco.setMensagem(faleConosco.getMensagem());
			vFaleConosco.setNome(faleConosco.getNome());
			faleConoscoRepository.save(vFaleConosco);
			
			
		}
		

	}


	@Override
	public void delete(long id) {
		this.faleConoscoRepository.deleteById(id);

	}

	@Override
	public List<FaleConosco> list() {
		return this.faleConoscoRepository.findAll();
	}

	@Override
	public FaleConosco findById(long id) {
		Optional<FaleConosco> optionalFaleConosco = faleConoscoRepository.findById(id);
		if (optionalFaleConosco.isPresent()) {
			return  faleConoscoRepository.getOne(id);
		}
		return null;
	}

	@Override
	public boolean atualizar(FaleConosco fale) {
		
		Optional<FaleConosco> optionalFaleConosco = faleConoscoRepository.findById(fale.getId());
		if (optionalFaleConosco.isPresent()) {
			FaleConosco vFaleConosco = faleConoscoRepository.getOne(fale.getId());
			vFaleConosco.setEmail(fale.getEmail());
			vFaleConosco.setMensagem(fale.getMensagem());
			vFaleConosco.setNome(fale.getNome());
			faleConoscoRepository.save(vFaleConosco);
			
			return true;
		}
		return false;
	}
	

}
