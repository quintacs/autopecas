package br.com.autopecas.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.autopecas.modelo.Oficina;

@Component
@Service
public interface OficinaService extends AutoPecasService{

	void save(Oficina oficina);
	void update(Oficina oficina);
	Oficina findById(long id);
	boolean atualizar(Oficina oficina);
	void delete(long id);
	List<Oficina> list();
}
