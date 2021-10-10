package com.quero2.pay.dto;

import com.quero2.pay.entities.Funcionario;

public class FuncionarioDTO {

	private Long id;
	private String nome;
	private String cargo;
	private Double salario;
	
	private Long empresa_id;
	
	public FuncionarioDTO() {
		
	}

	public FuncionarioDTO(Long id, String nome, String cargo, Double salario, Long empresa_id) {
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.empresa_id = empresa_id;
	}
	
	public FuncionarioDTO(Funcionario entity) {
		id = entity.getId();
		nome = entity.getNome();
		cargo = entity.getCargo();
		salario = entity.getSalario();
		empresa_id = entity.getEmpresa().getId();
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Long getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(Long empresa_id) {
		this.empresa_id = empresa_id;
	}
}