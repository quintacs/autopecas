package br.com.autopecas.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.autopecas.modelo.Usuario;

@Component
@Service
public interface UsuarioService {

	void save(Usuario usuario);
	void update(Usuario usuario);
	Usuario findById(long id);
	boolean atualizar(Usuario usuario);
	void delete(long id);
	List<Usuario> list();
}
