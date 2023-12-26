package br.com.autopecas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autopecas.modelo.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{

}
