package com.quero2.pay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quero2.pay.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
