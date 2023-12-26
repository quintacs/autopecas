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

import br.com.autopecas.dto.PecaDto;
import br.com.autopecas.form.PecaForm;
import br.com.autopecas.modelo.Peca;
import br.com.autopecas.service.PecaService;

@RestController
@RequestMapping("AutoPecas/Peca")
public class PecaController  {

	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private Peca peca;
	
	@GetMapping("/teste")
	public String Teste() {
		return "Peca Teste ok";
	}
	
	@GetMapping
	public ResponseEntity<List<PecaDto>> lista() {//@PathVariable long id
		List<PecaDto> listPecaDto = new ArrayList<PecaDto>();
		//if (id == 0) {
			List<Peca> lsPeca = pecaService.list();
			
			if(!lsPeca.isEmpty()) {
				
				for (Peca peca : lsPeca) {
					listPecaDto.add(new PecaDto(peca));
				}
				return  ResponseEntity.ok(listPecaDto);
				
			}else {
				
				return ResponseEntity.notFound().build();
			}
			//return pecaService.listar();
		/*} else {
			List<Peca> lsPeca = pecaService.listar(id);
			for (Peca peca : lsPeca) {
				listPecaDto.add(new PecaDto(peca));
			}
			return listPecaDto;
			//return pecaService.listar(id);
		}*/
	}
	
	@PostMapping
	public ResponseEntity<PecaDto> cadastrar(@RequestBody @Valid PecaForm form, UriComponentsBuilder uriBuilder) {
		  peca = new Peca(form);
		pecaService.save(peca);
		
		URI uri = uriBuilder.path("/Pecas/{id}").buildAndExpand(peca.getId()).toUri();
		return ResponseEntity.created(uri).body(new PecaDto(peca));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PecaDto> detalhar(@PathVariable Long id) {
			 peca = pecaService.findById(id);
		if (peca != null) {
			return ResponseEntity.ok(new PecaDto(peca));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PecaDto> atualizar(@PathVariable Long id, @RequestBody @Valid PecaForm form) {
		
		peca = new Peca(form);
		peca.setId(id);
		
		if (pecaService.atualizar(peca) ) {
			return ResponseEntity.ok(new PecaDto(peca));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id ) {
		 peca = pecaService.findById(id);
		if (peca != null) {
			//pecaService.deletar(peca);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
