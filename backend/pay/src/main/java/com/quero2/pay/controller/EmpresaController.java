package com.quero2.pay.controller;

import javax.validation.Valid;

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

import com.quero2.pay.dto.EmpresaDTO;
import com.quero2.pay.service.EmpresaService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;
	
	@GetMapping
	public ResponseEntity<Page<EmpresaDTO>> findAll(Pageable pageable){
		Page<EmpresaDTO> list = service.findAll(pageable);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmpresaDTO> findById(@PathVariable Long id){
		EmpresaDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<EmpresaDTO> insert(@Valid @RequestBody EmpresaDTO dto){
		EmpresaDTO empresa = service.insert(dto);
		
		return ResponseEntity.ok().body(empresa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmpresaDTO> update(@PathVariable Long id, @RequestBody EmpresaDTO dto){
		EmpresaDTO empresa = service.update(id, dto);
		
		return ResponseEntity.ok().body(empresa);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
