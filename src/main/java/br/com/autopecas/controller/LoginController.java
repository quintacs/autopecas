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

import br.com.autopecas.dto.LoginDto;
import br.com.autopecas.form.LoginForm;
import br.com.autopecas.modelo.Login;
import br.com.autopecas.service.LoginService;

@RestController
@RequestMapping("AutoPecas/Login")
public class LoginController  {

	@Autowired
	LoginService loginService;
	
	@Autowired
	Login login;
	
	@GetMapping("/teste")
	public String Teste() {
		return "Login Teste ok";
	}
	
	@GetMapping
	public ResponseEntity<List<LoginDto>> lista() {//@PathVariable long id
		List<LoginDto> listLoginDto = new ArrayList<LoginDto>();
		//if (id == 0) {
			List<Login> lsLogin = loginService.list();
			
			if(!lsLogin.isEmpty()) {
				
				for (Login login : lsLogin) {
					listLoginDto.add(new LoginDto(login));
				}
				return  ResponseEntity.ok(listLoginDto);
				
			}else {
				
				return ResponseEntity.notFound().build();
			}
			//return loginService.listar();
		/*} else {
			List<Login> lsLogin = loginService.listar(id);
			for (Login login : lsLogin) {
				listLoginDto.add(new LoginDto(login));
			}
			return listLoginDto;
			//return loginService.listar(id);
		}*/
	}
	
	@PostMapping
	public ResponseEntity<LoginDto> cadastrar(@RequestBody @Valid LoginForm form, UriComponentsBuilder uriBuilder) {
		  login = new Login(form);
		loginService.save(login);
		
		URI uri = uriBuilder.path("/Logins/{id}").buildAndExpand(login.getId()).toUri();
		return ResponseEntity.created(uri).body(new LoginDto(login));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LoginDto> detalhar(@PathVariable Long id) {
			 login = loginService.findById(id);
		if (login != null) {
			return ResponseEntity.ok(new LoginDto(login));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LoginDto> atualizar(@PathVariable Long id, @RequestBody @Valid LoginForm form) {
		
		login = new Login(form);
		login.setId(id);
		
		if (loginService.atualizar(login) ) {
			return ResponseEntity.ok(new LoginDto(login));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id ) {
		 login = loginService.findById(id);
		if (login != null) {
			//loginService.deletar(login);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
