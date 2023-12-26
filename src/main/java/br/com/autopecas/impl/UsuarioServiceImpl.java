package br.com.autopecas.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.autopecas.modelo.Usuario;
import br.com.autopecas.repository.UsuarioRepository;
import br.com.autopecas.service.UsuarioService;

@Component
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuario.getIdUsuario());
		if (optionalUsuario.isPresent()) {
			Usuario vUsuario = usuarioRepository.getOne(usuario.getIdUsuario());
			vUsuario.setCelular(usuario.getCelular());
			vUsuario.setCpf(usuario.getCpf());
			vUsuario.setEmail(usuario.getEmail());
			vUsuario.setEmpresa(usuario.getEmpresa());
			vUsuario.setEndereco(usuario.getEndereco());
			vUsuario.setNome(usuario.getNome());
			vUsuario.setTelefone(usuario.getTelefone());
			vUsuario.setLogin(usuario.getLogin());
			usuarioRepository.save(vUsuario);
		}
		

	}


	@Override
	public void delete(long id) {
		this.usuarioRepository.deleteById(id);

	}

	@Override
	public List<Usuario> list() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(long id) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		if (optionalUsuario.isPresent()) {
			return  usuarioRepository.getOne(id);
		}
		return null;
	}

	@Override
	public boolean atualizar(Usuario usuario) {
		 Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuario.getIdUsuario());
			if (optionalUsuario.isPresent()) {
				Usuario vUsuario = usuarioRepository.getOne(usuario.getIdUsuario());
				vUsuario.setCelular(usuario.getCelular());
				vUsuario.setCpf(usuario.getCpf());
				vUsuario.setEmail(usuario.getEmail());
				vUsuario.setEmpresa(usuario.getEmpresa());
				vUsuario.setEndereco(usuario.getEndereco());
				vUsuario.setNome(usuario.getNome());
				vUsuario.setTelefone(usuario.getTelefone());
				vUsuario.setLogin(usuario.getLogin());
				usuarioRepository.save(vUsuario);
				
				return true;
			}
		return false;
	}

}
