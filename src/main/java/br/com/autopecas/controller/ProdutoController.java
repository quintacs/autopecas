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

import br.com.autopecas.dto.ProdutoDto;
import br.com.autopecas.form.ProdutoForm;
import br.com.autopecas.modelo.Produto;
import br.com.autopecas.service.ProdutoService;

@RestController
@RequestMapping("AutoPecas/Produto")
public class ProdutoController  {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private Produto produto;
	
	
	@GetMapping("/teste")
	public String Teste() {
		return "Produto Teste ok";
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDto>> lista() {//@PathVariable long id
		List<ProdutoDto> listProdutoDto = new ArrayList<ProdutoDto>();
		//if (id == 0) {
			List<Produto> lsProduto = produtoService.list();
			
			if(!lsProduto.isEmpty()) {
				
				for (Produto produto : lsProduto) {
					listProdutoDto.add(new ProdutoDto(produto));
				}
				return  ResponseEntity.ok(listProdutoDto);
				
			}else {
				
				return ResponseEntity.notFound().build();
			}
			//return produtoService.listar();
		/*} else {
			List<Produto> lsProduto = produtoService.listar(id);
			for (Produto produto : lsProduto) {
				listProdutoDto.add(new ProdutoDto(produto));
			}
			return listProdutoDto;
			//return produtoService.listar(id);
		}*/
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
		  produto = new Produto(form);
		produtoService.save(produto);
		
		URI uri = uriBuilder.path("/Produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDto> detalhar(@PathVariable Long id) {
			 produto = produtoService.findById(id);
		if (produto != null) {
			return ResponseEntity.ok(new ProdutoDto(produto));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoForm form) {
		
		produto = new Produto(form);
		produto.setId(id);
		
		if (produtoService.atualizar(produto) ) {
			return ResponseEntity.ok(new ProdutoDto(produto));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id ) {
		 produto = produtoService.findById(id);
		if (produto != null) {
			//produtoService.deletar(produto);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
