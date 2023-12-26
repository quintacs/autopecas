package br.com.autopecas.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.autopecas.modelo.Servico;

@Component
@Service
public interface ServicoService extends AutoPecasService{

	void save(Servico servico);
	void update(Servico servico);
	Servico findById(long id);
	boolean atualizar(Servico servico);
	void delete(long id);
	List<Servico> list();
}
