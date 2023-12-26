package br.com.autopecas.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.autopecas.modelo.Produto;

@Component
@Service
public interface ProdutoService extends AutoPecasService{

	void save(Produto produto);
	void update(Produto produto);
	Produto findById(long id);
	boolean atualizar(Produto produto);
	void delete(long id);
	List<Produto> list();
}
