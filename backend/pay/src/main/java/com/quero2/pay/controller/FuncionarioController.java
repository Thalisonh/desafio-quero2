package com.quero2.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quero2.pay.dto.FuncionarioDTO;
import com.quero2.pay.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Page<FuncionarioDTO>> findAll(Pageable pageable, @PathVariable Long id){
		Page<FuncionarioDTO> list = service.findAll(pageable, id);
		
		return ResponseEntity.ok().body(list);
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id){
//		FuncionarioDTO dto = service.findById(id);
//		
//		return ResponseEntity.ok().body(dto);
//	}
	
	@PostMapping
	public ResponseEntity<FuncionarioDTO> insert(@RequestBody FuncionarioDTO dto){
		FuncionarioDTO empresa = service.insert(dto);
		
		return ResponseEntity.ok().body(empresa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @RequestBody FuncionarioDTO dto){
		FuncionarioDTO empresa = service.update(id, dto);
		
		return ResponseEntity.ok().body(empresa);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
