package com.quero2.pay.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.quero2.pay.dto.FuncionarioDTO;
import com.quero2.pay.entities.Empresa;
import com.quero2.pay.entities.Funcionario;
import com.quero2.pay.repositories.FuncionarioRepository;
import com.quero2.pay.service.exceptions.DatabaseException;
import com.quero2.pay.service.exceptions.ResourceNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public List<FuncionarioDTO> findAll(){
		List<Funcionario> list = repository.findAll();
		
		return list.stream().map(x -> new FuncionarioDTO(x)).collect(Collectors.toList());
	}
	
	public FuncionarioDTO findById(Long id){
		Optional<Funcionario> obj = repository.findById(id);
		Funcionario entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		
		return new FuncionarioDTO(entity);
	}
	
	public FuncionarioDTO insert(FuncionarioDTO dto) {
		Funcionario entity = new Funcionario();

		copyToEntity(dto, entity);
		entity = repository.save(entity);
		
		return new FuncionarioDTO(entity);
	}
	
	public FuncionarioDTO update(Long id, FuncionarioDTO dto) {
		Optional<Funcionario> obj = repository.findById(id);
		Funcionario entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		
		copyToEntity(dto, entity);
		entity = repository.save(entity);
		
		return new FuncionarioDTO(entity);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
		
	}
	
	public void copyToEntity(FuncionarioDTO dto, Funcionario entity) {
		entity.setNome(dto.getNome());
		entity.setCargo(dto.getCargo());
		entity.setSalario(dto.getSalario());
		
		Empresa empresa = new Empresa();
		empresa.setId(dto.getEmpresa_id());
		
		entity.setEmpresa(empresa);
	}
}