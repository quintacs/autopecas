package br.com.autopecas.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.autopecas.modelo.Peca;
import br.com.autopecas.repository.PecaRepository;
import br.com.autopecas.service.PecaService;

@Component
@Transactional
public class PecaServiceImpl implements PecaService {

	@Autowired
	PecaRepository pecaRepository;
	
	@Override
	public void save(Peca peca) {
		pecaRepository.save(peca);
	}

	@Override
	public void update(Peca peca) {
		
		Optional<Peca> optionalPeca = pecaRepository.findById(peca.getId());
		if (optionalPeca.isPresent()) {
			Peca vPeca = pecaRepository.getOne(peca.getId());
			vPeca.setAno(peca.getAno());
			vPeca.setCor(peca.getCor());
			vPeca.setLojas(peca.getLoja());
			vPeca.setMarca(peca.getMarca());
			vPeca.setModelo(peca.getModelo());
			vPeca.setNome(peca.getNome());
			pecaRepository.save(vPeca);
		}
		

	}


	@Override
	public void delete(long id) {
		this.pecaRepository.deleteById(id);

	}

	@Override
	public List<Peca> list() {
		return this.pecaRepository.findAll();
	}

	@Override
	public Peca findById(long id) {
		Optional<Peca> optionalPeca = pecaRepository.findById(id);
		if (optionalPeca.isPresent()) {
			return  pecaRepository.getOne(id);
		}
		return null;
	}

	@Override
	public boolean atualizar(Peca peca) {
		 Optional<Peca> optionalPeca = pecaRepository.findById(peca.getId());
			if (optionalPeca.isPresent()) {
				Peca vPeca = pecaRepository.getOne(peca.getId());
				vPeca.setAno(peca.getAno());
				vPeca.setCor(peca.getCor());
				vPeca.setLojas(peca.getLoja());
				vPeca.setMarca(peca.getMarca());
				vPeca.setModelo(peca.getModelo());
				vPeca.setNome(peca.getNome());
				pecaRepository.save(vPeca);
				
				return true;
			}
		return false;
	}

}
