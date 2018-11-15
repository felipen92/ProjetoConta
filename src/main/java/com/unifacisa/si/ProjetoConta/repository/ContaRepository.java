package com.unifacisa.si.ProjetoConta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.si.ProjetoConta.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, String> {
	

}
