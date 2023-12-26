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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.autopecas.dto.EmpresaDto;
import br.com.autopecas.form.EmpresaForm;
import br.com.autopecas.modelo.Empresa;
import br.com.autopecas.service.EmpresaService;


@RestController
@RequestMapping("AutoPecas/Empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private Empresa empresa;
	
	@GetMapping("/teste")
	public String Teste() {
		return "Empresa Teste ok";
	}
	
	@GetMapping
	public ResponseEntity<List<EmpresaDto>> lista() {//@PathVariable long id
		List<EmpresaDto> listEmpresaDto = new ArrayList<EmpresaDto>();
		//if (id == 0) {
			List<Empresa> lsEmpresa = empresaService.list();
			
			if(!lsEmpresa.isEmpty()) {
				
				for (Empresa empresa : lsEmpresa) {
					listEmpresaDto.add(new EmpresaDto(empresa));
				}
				return  ResponseEntity.ok(listEmpresaDto);
				
			}else {
				
				return ResponseEntity.notFound().build();
			}
			//return empresaService.listar();
		/*} else {
			List<Empresa> lsEmpresa = empresaService.listar(id);
			for (Empresa empresa : lsEmpresa) {
				listEmpresaDto.add(new EmpresaDto(empresa));
			}
			return listEmpresaDto;
			//return empresaService.listar(id);
		}*/
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<EmpresaDto> cadastrar(@RequestBody @Valid EmpresaForm form, UriComponentsBuilder uriBuilder) {
		  empresa = new Empresa(form);
		empresaService.save(empresa);
		
		URI uri = uriBuilder.path("/Empresas/{id}").buildAndExpand(empresa.getId()).toUri();
		return ResponseEntity.created(uri).body(new EmpresaDto(empresa));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmpresaDto> detalhar(@PathVariable Long id) {
			 empresa = empresaService.findById(id);
		if (empresa != null) {
			return ResponseEntity.ok(new EmpresaDto(empresa));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmpresaDto> atualizar(@PathVariable Long id, @RequestBody @Valid EmpresaForm form) {
		
		empresa = new Empresa(form);
		empresa.setId(id);
		
		if (empresaService.atualizar(empresa) ) {
			return ResponseEntity.ok(new EmpresaDto(empresa));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id ) {
		 empresa = empresaService.findById(id);
		if (empresa != null) {
			//empresaService.deletar(empresa);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
