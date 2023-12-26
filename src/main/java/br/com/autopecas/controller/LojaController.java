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

import br.com.autopecas.dto.LojaDto;
import br.com.autopecas.form.LojaForm;
import br.com.autopecas.modelo.Loja;
import br.com.autopecas.service.LojaService;

@RestController
@RequestMapping("AutoPecas/Loja")
public class LojaController {

	@Autowired
	private LojaService lojaService;
	
	@Autowired
	private Loja loja;
	
	@GetMapping("/teste")
	public String Teste() {
		return "Loja Teste ok";
	}
	
	@GetMapping
	public ResponseEntity<List<LojaDto>> lista() {//@PathVariable long id
		List<LojaDto> listLojaDto = new ArrayList<LojaDto>();
		//if (id == 0) {
			List<Loja> lsLoja = lojaService.list();
			
			if(!lsLoja.isEmpty()) {
				
				for (Loja loja : lsLoja) {
					listLojaDto.add(new LojaDto(loja));
				}
				return  ResponseEntity.ok(listLojaDto);
				
			}else {
				
				return ResponseEntity.notFound().build();
			}
			//return lojaService.listar();
		/*} else {
			List<Loja> lsLoja = lojaService.listar(id);
			for (Loja loja : lsLoja) {
				listLojaDto.add(new LojaDto(loja));
			}
			return listLojaDto;
			//return lojaService.listar(id);
		}*/
	}
	
	@PostMapping
	public ResponseEntity<LojaDto> cadastrar(@RequestBody @Valid LojaForm form, UriComponentsBuilder uriBuilder) {
		  loja = new Loja(form);
		lojaService.save(loja);
		
		URI uri = uriBuilder.path("/Lojas/{id}").buildAndExpand(loja.getId()).toUri();
		return ResponseEntity.created(uri).body(new LojaDto(loja));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LojaDto> detalhar(@PathVariable Long id) {
			 loja = lojaService.findById(id);
		if (loja != null) {
			return ResponseEntity.ok(new LojaDto(loja));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LojaDto> atualizar(@PathVariable Long id, @RequestBody @Valid LojaForm form) {
		
		loja = new Loja(form);
		loja.setId(id);
		
		if (lojaService.atualizar(loja) ) {
			return ResponseEntity.ok(new LojaDto(loja));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id ) {
		 loja = lojaService.findById(id);
		if (loja != null) {
			//lojaService.deletar(loja);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
