package com.quero2.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quero2.pay.entities.Endereco;
import com.quero2.pay.service.EnderecoService;;

@RestController
public class EnderecoController {

	@Autowired
	private EnderecoService service;

	@GetMapping("/{cep}")
	public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
		Endereco endereco = service.getCep(cep);
		
		return ResponseEntity.ok().body(endereco); 
	}
}
