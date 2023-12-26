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

import br.com.autopecas.dto.ServicoDto;
import br.com.autopecas.form.ServicoForm;
import br.com.autopecas.modelo.Servico;
import br.com.autopecas.service.ServicoService;

@RestController
@RequestMapping("AutoPecas/Servico")
public class ServicoController  {

	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private Servico servico;
	
	
	@GetMapping("/teste")
	public String Teste() {
		return "Servico Teste ok";
	}
	
	@GetMapping
	public ResponseEntity<List<ServicoDto>> lista() {//@PathVariable long id
		List<ServicoDto> listServicoDto = new ArrayList<ServicoDto>();
		//if (id == 0) {
			List<Servico> lsServico = servicoService.list();
			
			if(!lsServico.isEmpty()) {
				
				for (Servico servico : lsServico) {
					listServicoDto.add(new ServicoDto(servico));
				}
				return  ResponseEntity.ok(listServicoDto);
				
			}else {
				
				return ResponseEntity.notFound().build();
			}
			//return servicoService.listar();
		/*} else {
			List<Servico> lsServico = servicoService.listar(id);
			for (Servico servico : lsServico) {
				listServicoDto.add(new ServicoDto(servico));
			}
			return listServicoDto;
			//return servicoService.listar(id);
		}*/
	}
	
	@PostMapping
	public ResponseEntity<ServicoDto> cadastrar(@RequestBody @Valid ServicoForm form, UriComponentsBuilder uriBuilder) {
		  servico = new Servico(form);
		servicoService.save(servico);
		
		URI uri = uriBuilder.path("/Servicos/{id}").buildAndExpand(servico.getId()).toUri();
		return ResponseEntity.created(uri).body(new ServicoDto(servico));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ServicoDto> detalhar(@PathVariable Long id) {
			 servico = servicoService.findById(id);
		if (servico != null) {
			return ResponseEntity.ok(new ServicoDto(servico));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ServicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid ServicoForm form) {
		
		servico = new Servico(form);
		servico.setId(id);
		
		if (servicoService.atualizar(servico) ) {
			return ResponseEntity.ok(new ServicoDto(servico));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id ) {
		 servico = servicoService.findById(id);
		if (servico != null) {
			//servicoService.deletar(servico);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
