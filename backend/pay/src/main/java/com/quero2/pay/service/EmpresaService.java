package com.quero2.pay.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quero2.pay.dto.EmpresaDTO;
import com.quero2.pay.dto.FuncionarioDTO;
import com.quero2.pay.entities.Empresa;
import com.quero2.pay.entities.Endereco;
import com.quero2.pay.entities.Funcionario;
import com.quero2.pay.repositories.EmpresaRepository;
import com.quero2.pay.repositories.EnderecoRepository;
import com.quero2.pay.repositories.FuncionarioRepository;
import com.quero2.pay.service.exceptions.DatabaseException;
import com.quero2.pay.service.exceptions.ResourceNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Transactional(readOnly = true)
	public List<EmpresaDTO> findAll() {
		List<Empresa> empresas = repository.findAll();

		return empresas.stream().map(x -> new EmpresaDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public EmpresaDTO findById(Long id) {
		Optional<Empresa> obj = repository.findById(id);
		Empresa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new EmpresaDTO(entity, entity.getFuncionario());
	}

	@Transactional
	public EmpresaDTO insert(EmpresaDTO dto) {
		Empresa entity = new Empresa();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);

		return new EmpresaDTO(entity, entity.getFuncionario());
	}

	public EmpresaDTO update(Long id, EmpresaDTO dto) {
		Optional<Empresa> obj = repository.findById(id);
		Empresa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new EmpresaDTO(entity, entity.getFuncionario());
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

	public void copyDtoToEntity(EmpresaDTO dto, Empresa entity) {
		entity.setNome(dto.getNome());
		entity.setTelefone(dto.getTelefone());

		Optional<Endereco> enderecoObj = enderecoRepository.findById(dto.getEndereco_id());
		Endereco endereco = enderecoObj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		entity.setEndereco(endereco);

		for (FuncionarioDTO funcionarioDTO : dto.getFuncionarios()) {
			Optional<Funcionario> funcionarioObj = funcionarioRepository.findById(funcionarioDTO.getId());
			Funcionario funcionario = funcionarioObj
					.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
			entity.getFuncionario().add(funcionario);
		}
	}

}
