package com.quero2.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quero2.pay.dto.EnderecoDTO;
import com.quero2.pay.service.EnderecoService;;

@RestController
public class EnderecoController {

	@Autowired
	private EnderecoService service;

	@PostMapping
	public ResponseEntity<EnderecoDTO> getCep(@RequestBody EnderecoDTO dto) {
		EnderecoDTO endereco = service.getCep(dto.getCep());
		endereco.setComplemento(dto.getComplemento());
		endereco.setNumero(dto.getNumero());
		endereco.setEmpresa_id(dto.getEmpresa_id());
		
		service.insert(endereco);
		
		return ResponseEntity.ok().body(endereco); 
	}
	
	@GetMapping("/{cep}")
	public ResponseEntity<EnderecoDTO> findByCep(@PathVariable String cep){
		EnderecoDTO endereco = service.getCep(cep);
		
		return ResponseEntity.ok().body(endereco);
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
