package br.com.autopecas.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.autopecas.dto.UsuarioDto;
import br.com.autopecas.form.UsuarioForm;
import br.com.autopecas.modelo.Usuario;
import br.com.autopecas.service.UsuarioService;



@RestController
@RequestMapping("AutoPecas/Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private Usuario usuario;
	
	
	@GetMapping("/teste")
	public String Teste() {
		return "Usuario Teste ok";
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> lista() {//@PathVariable long id
		List<UsuarioDto> listUsuarioDto = new ArrayList<UsuarioDto>();
		//if (id == 0) {
			List<Usuario> lsUsuario = usuarioService.list();
			
			if(!lsUsuario.isEmpty()) {
				
				for (Usuario usuario : lsUsuario) {
					listUsuarioDto.add(new UsuarioDto(usuario));
				}
				return  ResponseEntity.ok(listUsuarioDto);
				
			}else {
				
				return ResponseEntity.notFound().build();
			}
			//return usuarioService.listar();
		/*} else {
			List<Usuario> lsUsuario = usuarioService.listar(id);
			for (Usuario usuario : lsUsuario) {
				listUsuarioDto.add(new UsuarioDto(usuario));
			}
			return listUsuarioDto;
			//return usuarioService.listar(id);
		}*/
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
		  usuario = new Usuario(form);
		usuarioService.save(usuario);
		
		URI uri = uriBuilder.path("/Usuarios/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> detalhar(@PathVariable Long id) {
			 usuario = usuarioService.findById(id);
		if (usuario != null) {
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioForm form) {
		
		usuario = new Usuario(form);
		usuario.setIdUsuario(id);
		
		if (usuarioService.atualizar(usuario) ) {
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id ) {
		 usuario = usuarioService.findById(id);
		if (usuario != null) {
			//usuarioService.deletar(usuario);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
