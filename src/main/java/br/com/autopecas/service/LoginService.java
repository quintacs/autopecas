package br.com.autopecas.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.autopecas.modelo.Login;

@Component
@Service
public interface LoginService {

	void save(Login login);
	void update(Login login);
	Login findById(long id);
	boolean atualizar(Login login);
	void delete(long id);
	List<Login> list();
}
