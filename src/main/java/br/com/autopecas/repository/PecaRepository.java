package br.com.autopecas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autopecas.modelo.Peca;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long>{

}
