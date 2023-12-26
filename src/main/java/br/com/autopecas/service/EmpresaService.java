package br.com.autopecas.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.autopecas.modelo.Empresa;

@Component
@Service
public interface EmpresaService {

	void save(Empresa empresa);
	void update(Empresa empresa);
	Empresa findById(long id);
	boolean atualizar(Empresa empresa);
	void delete(long id);
	List<Empresa> list();

}
