package br.com.autopecas.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.autopecas.modelo.Peca;

@Component
@Service
public interface PecaService extends AutoPecasService{

	void save(Peca peca);
	void update(Peca peca);
	Peca findById(long id);
	boolean atualizar(Peca peca);
	void delete(long id);
	List<Peca> list();
}
