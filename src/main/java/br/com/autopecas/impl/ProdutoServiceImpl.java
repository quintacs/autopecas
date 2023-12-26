package br.com.autopecas.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.autopecas.modelo.Produto;
import br.com.autopecas.repository.ProdutoRepository;
import br.com.autopecas.service.ProdutoService;

@Component
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Override
	public void save(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public void update(Produto produto) {
		
		Optional<Produto> optionalProduto = produtoRepository.findById(produto.getId());
		if (optionalProduto.isPresent()) {
			Produto vProduto = produtoRepository.getOne(produto.getId());
			vProduto.setDescricao(produto.getDescricao());
			vProduto.setLojas(produto.getLoja());
			vProduto.setMarca(produto.getMarca());
			vProduto.setNome(produto.getNome());
			produtoRepository.save(vProduto);

		}
		

	}


	@Override
	public void delete(long id) {
		this.produtoRepository.deleteById(id);

	}

	@Override
	public List<Produto> list() {
		return this.produtoRepository.findAll();
	}

	@Override
	public Produto findById(long id) {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		if (optionalProduto.isPresent()) {
			return  produtoRepository.getOne(id);
		}
		return null;
	}

	@Override
	public boolean atualizar(Produto produto) {
		 Optional<Produto> optionalProduto = produtoRepository.findById(produto.getId());
			if (optionalProduto.isPresent()) {
				Produto vProduto = produtoRepository.getOne(produto.getId());
				vProduto.setDescricao(produto.getDescricao());
				vProduto.setLojas(produto.getLoja());
				vProduto.setMarca(produto.getMarca());
				vProduto.setNome(produto.getNome());
				produtoRepository.save(vProduto);
				
				return true;
			}
		return false;
	}
}
