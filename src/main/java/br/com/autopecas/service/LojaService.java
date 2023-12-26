package br.com.autopecas.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.autopecas.modelo.Loja;

@Component
@Service
public interface LojaService extends AutoPecasService{

	void save(Loja loja);
	void update(Loja loja);
	Loja findById(long id);
	boolean atualizar(Loja loja);
	void delete(long id);
	List<Loja> list();
}
