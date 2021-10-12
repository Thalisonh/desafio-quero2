package com.quero2.pay.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quero2.pay.components.ViaCep;
import com.quero2.pay.dto.EnderecoDTO;
import com.quero2.pay.entities.Empresa;
import com.quero2.pay.entities.Endereco;
import com.quero2.pay.repositories.EnderecoRepository;
import com.quero2.pay.service.exceptions.DatabaseException;
import com.quero2.pay.service.exceptions.ResourceNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;

	@Autowired
	private ViaCep cepService;

	public Endereco getCep(String cep) {
		Endereco endereco = cepService.buscaEnderecoPorCep(cep);
		
		return endereco; 
	}
	
	@Transactional(readOnly = true)
	public List<EnderecoDTO> findAll(){
		List<Endereco> list = repository.findAll();
		
		return list.stream().map(x -> new EnderecoDTO(x, x.getEmpresa())).collect(Collectors.toList());
	}
	
	@Transactional
	public EnderecoDTO insert(EnderecoDTO dto) {
		try {
			Endereco entity = new Endereco();
			copyDtoToEntity(entity, dto);
			
			entity = repository.save(entity);
			
			return new EnderecoDTO(entity, entity.getEmpresa());
		}catch (InvalidDataAccessApiUsageException e) {
			throw new ResourceNotFoundException("Id empresa not found " + dto.getEmpresa_id());
		}
	}
	
	@Transactional
	public EnderecoDTO update(Long id, EnderecoDTO dto) {
		try {
			Endereco entity = repository.getOne(id);
			copyDtoToEntity(entity, dto);
			entity = repository.save(entity);
			return new EnderecoDTO(entity, entity.getEmpresa());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	public void copyDtoToEntity(Endereco entity, EnderecoDTO dto) {
		entity.setBairro(dto.getBairro());
		entity.setCep(dto.getCep());
		entity.setComplemento(dto.getComplemento());
		
		Empresa empresa = new Empresa();
		empresa.setId(dto.getEmpresa_id());
		
		entity.setEmpresa(empresa);
		entity.setEstado(dto.getEstado());
		entity.setLocalidade(dto.getLocalidade());
		entity.setLogradouro(dto.getLogradouro());
		entity.setNumero(dto.getNumero());
		
	}
}
