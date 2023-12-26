package br.com.autopecas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autopecas.modelo.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
