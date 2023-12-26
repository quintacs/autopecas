package br.com.autopecas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autopecas.modelo.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>{

}
