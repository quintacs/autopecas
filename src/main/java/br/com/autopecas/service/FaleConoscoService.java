package br.com.autopecas.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.autopecas.modelo.FaleConosco;

@Component
@Service
public interface FaleConoscoService {

	void save(FaleConosco fale);
	void update(FaleConosco fale);
	FaleConosco findById(long id);
	boolean atualizar(FaleConosco fale);
	void delete(long id);
	List<FaleConosco> list();
}
