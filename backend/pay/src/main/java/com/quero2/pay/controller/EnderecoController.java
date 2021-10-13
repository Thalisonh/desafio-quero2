package com.quero2.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quero2.pay.dto.EnderecoDTO;
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
	
	@GetMapping
	public ResponseEntity<Page<EnderecoDTO>> findAll(Pageable pageable){
		Page<EnderecoDTO> list = service.findAll(pageable);
		
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EnderecoDTO> update(@RequestBody EnderecoDTO dto, @PathVariable Long id){
		EnderecoDTO newEndereco = service.update(id, dto);
		
		return ResponseEntity.ok().body(newEndereco);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<EnderecoDTO> delete(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
