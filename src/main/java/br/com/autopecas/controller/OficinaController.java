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

import br.com.autopecas.dto.OficinaDto;
import br.com.autopecas.form.OficinaForm;
import br.com.autopecas.modelo.Oficina;
import br.com.autopecas.service.OficinaService;

@RestController
@RequestMapping("AutoPecas/Oficina")
public class OficinaController  {

	@Autowired
	private OficinaService oficinaService;
	
	@Autowired
	private Oficina oficina;
	
	@GetMapping("/teste")
	public String Teste() {
		return "Oficina Teste ok";
	}
	
	@GetMapping
	public ResponseEntity<List<OficinaDto>> lista() {//@PathVariable long id
		List<OficinaDto> listOficinaDto = new ArrayList<OficinaDto>();
		//if (id == 0) {
			List<Oficina> lsOficina = oficinaService.list();
			
			if(!lsOficina.isEmpty()) {
				
				for (Oficina oficina : lsOficina) {
					listOficinaDto.add(new OficinaDto(oficina));
				}
				return  ResponseEntity.ok(listOficinaDto);
				
			}else {
				
				return ResponseEntity.notFound().build();
			}
			//return oficinaService.listar();
		/*} else {
			List<Oficina> lsOficina = oficinaService.listar(id);
			for (Oficina oficina : lsOficina) {
				listOficinaDto.add(new OficinaDto(oficina));
			}
			return listOficinaDto;
			//return oficinaService.listar(id);
		}*/
	}
	
	@PostMapping
	public ResponseEntity<OficinaDto> cadastrar(@RequestBody @Valid OficinaForm form, UriComponentsBuilder uriBuilder) {
		  oficina = new Oficina(form);
		oficinaService.save(oficina);
		
		URI uri = uriBuilder.path("/Oficinas/{id}").buildAndExpand(oficina.getId()).toUri();
		return ResponseEntity.created(uri).body(new OficinaDto(oficina));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OficinaDto> detalhar(@PathVariable Long id) {
			 oficina = oficinaService.findById(id);
		if (oficina != null) {
			return ResponseEntity.ok(new OficinaDto(oficina));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OficinaDto> atualizar(@PathVariable Long id, @RequestBody @Valid OficinaForm form) {
		
		oficina = new Oficina(form);
		oficina.setId(id);
		
		if (oficinaService.atualizar(oficina) ) {
			return ResponseEntity.ok(new OficinaDto(oficina));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id ) {
		 oficina = oficinaService.findById(id);
		if (oficina != null) {
			//oficinaService.deletar(oficina);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
