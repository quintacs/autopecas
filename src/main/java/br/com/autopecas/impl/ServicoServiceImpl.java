package br.com.autopecas.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.autopecas.modelo.Servico;
import br.com.autopecas.repository.ServicoRepository;
import br.com.autopecas.service.ServicoService;

@Component
@Transactional
public class ServicoServiceImpl implements ServicoService {

	@Autowired
	ServicoRepository servicoRepository;
	
	@Override
	public void save(Servico servico) {
		servicoRepository.save(servico);
	}

	@Override
	public void update(Servico servico) {
		
		Optional<Servico> optionalServico = servicoRepository.findById(servico.getId());
		if (optionalServico.isPresent()) {
			Servico vServico = servicoRepository.getOne(servico.getId());
			vServico.setDescricao(servico.getDescricao());
			vServico.setNome(servico.getNome());
			vServico.setOficinas(servico.getOficina());
			servicoRepository.save(vServico);
			
			
		}
		

	}


	@Override
	public void delete(long id) {
		this.servicoRepository.deleteById(id);

	}

	@Override
	public List<Servico> list() {
		return this.servicoRepository.findAll();
	}

	@Override
	public Servico findById(long id) {
		Optional<Servico> optionalEmpresa = servicoRepository.findById(id);
		if (optionalEmpresa.isPresent()) {
			return  servicoRepository.getOne(id);
		}
		return null;
	}

	@Override
	public boolean atualizar(Servico servico) {
		 Optional<Servico> optionalEmpresa = servicoRepository.findById(servico.getId());
			if (optionalEmpresa.isPresent()) {
				Servico vServico = servicoRepository.getOne(servico.getId());
				vServico.setDescricao(servico.getDescricao());
				vServico.setNome(servico.getNome());
				vServico.setOficinas(servico.getOficina());
				servicoRepository.save(vServico);
				
				return true;
			}
		return false;
	}

}
