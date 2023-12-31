package br.com.autopecas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autopecas.modelo.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
