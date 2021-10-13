package com.quero2.pay.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quero2.pay.entities.Empresa;
import com.quero2.pay.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	Page<Funcionario> findByEmpresa(Empresa empresa, Pageable pageable);

}