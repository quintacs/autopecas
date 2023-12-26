package br.com.autopecas.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.autopecas.modelo.Login;
import br.com.autopecas.repository.LoginRepository;
import br.com.autopecas.service.LoginService;

@Component
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public void save(Login login) {
		loginRepository.save(login);
	}

	@Override
	public void update(Login login) {
		
		Optional<Login> optionalLogin = loginRepository.findById(login.getId());
		if (optionalLogin.isPresent()) {
			Login vLogin = loginRepository.getOne(login.getId());
			vLogin.setNome(login.getNome());
			vLogin.setEmail(login.getEmail());
			vLogin.setSenha(login.getSenha());
			vLogin.setUsuario(login.getUsuario());
			loginRepository.save(vLogin);
			
			
		}
		

	}


	@Override
	public void delete(long id) {
		this.loginRepository.deleteById(id);

	}

	@Override
	public List<Login> list() {
		return this.loginRepository.findAll();
	}

	@Override
	public Login findById(long id) {
		Optional<Login> optionalLogin = loginRepository.findById(id);
		if (optionalLogin.isPresent()) {
			return  loginRepository.getOne(id);
		}
		return null;
	}

	@Override
	public boolean atualizar(Login login) {
		 Optional<Login> optionalLogin = loginRepository.findById(login.getId());
		if (optionalLogin.isPresent()) {
			Login vLogin = loginRepository.getOne(login.getId());
			vLogin.setNome(login.getNome());
			vLogin.setEmail(login.getEmail());
			vLogin.setSenha(login.getSenha());
			vLogin.setUsuario(login.getUsuario());
			loginRepository.save(vLogin);
			
			return true;
		}
		return false;
	}
}
