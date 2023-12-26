package br.com.autopecas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autopecas.modelo.FaleConosco;

@Repository
public interface FaleConoscoRepository  extends JpaRepository<FaleConosco, Long>{

	
}
