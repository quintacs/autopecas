package br.com.autopecas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autopecas.modelo.Empresa;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>  {

}
