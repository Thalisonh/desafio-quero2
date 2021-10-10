package com.quero2.pay.dto;

import java.util.ArrayList;
import java.util.List;

import com.quero2.pay.entities.Empresa;
import com.quero2.pay.entities.Funcionario;

public class EmpresaDTO {

	private Long id;
	private String nome;
	private Long endereco_id;
	private String telefone;
	private List<FuncionarioDTO> funcionarios = new ArrayList<>();
	
	public EmpresaDTO() {
		
	}

	public EmpresaDTO(Long id, String nome, Long endereco_id, String telefone, List<FuncionarioDTO> funcionarios) {
		this.id = id;
		this.nome = nome;
		this.endereco_id = endereco_id;
		this.telefone = telefone;
		this.funcionarios = funcionarios;
	}
	
	public EmpresaDTO(Empresa entity) {
		id = entity.getId();
		nome = entity.getNome();
		endereco_id = entity.getEndereco().getId();
		telefone = entity.getTelefone();
	}
	
	public EmpresaDTO(Empresa entity, List<Funcionario> funcionarios) {
		this(entity);//chama o contrutor de cima
		
		//para cada funcionario recebido passa para a lista de funcionarios
		funcionarios.forEach(fun -> this.funcionarios.add(new FuncionarioDTO(fun)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(Long endereco_id) {
		this.endereco_id = endereco_id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<FuncionarioDTO> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioDTO> funcionarios) {
		this.funcionarios = funcionarios;
	}
}