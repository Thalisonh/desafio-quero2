package com.quero2.pay.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.quero2.pay.entities.Funcionario;

public class FuncionarioDTO {

	private Long id;
	
	@Column(length=200)
	@NotBlank(message = "Namo é obrigatório")
	private String nome;
	
	@NotBlank(message = "Cargo is obrigatório")
	private String cargo;
	
	@NotBlank(message = "Salário é obrigatório")
	private Double salario;
	
	@NotBlank(message = "Id empresa é obrigatório")
	private Long empresa_id;
	
	private String nomeEmpresa;
	
	public FuncionarioDTO() {
		
	}

	public FuncionarioDTO(Long id, String nome, String cargo, Double salario, Long empresa_id, String nomeEmpresa) {
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.empresa_id = empresa_id;
		this.nomeEmpresa = nomeEmpresa;
	}
	
	public FuncionarioDTO(Funcionario entity) {
		id = entity.getId();
		nome = entity.getNome();
		cargo = entity.getCargo();
		salario = entity.getSalario();
		empresa_id = entity.getEmpresa().getId();
		nomeEmpresa = entity.getEmpresa().getNome();
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

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
}