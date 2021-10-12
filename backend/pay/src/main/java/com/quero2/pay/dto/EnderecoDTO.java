package com.quero2.pay.dto;

import com.quero2.pay.entities.Empresa;
import com.quero2.pay.entities.Endereco;

public class EnderecoDTO {
	private Long id;
	private String cep;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String localidade;
	private String estado;
	private Long empresa_id;
	
	public EnderecoDTO() {
		
	}

	public EnderecoDTO(Long id, String cep, String logradouro, Integer numero, String complemento, String bairro,
			String localidade, String estado, Long empresa_id) {
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.estado = estado;
		this.empresa_id = empresa_id;
	}
	
	public EnderecoDTO(Endereco entity) {
		id = entity.getId();
		cep = entity.getCep();
		logradouro = entity.getLogradouro();
		numero = entity.getNumero();
		complemento = entity.getComplemento();
		bairro = entity.getBairro();
		localidade = entity.getLocalidade();
		estado = entity.getEstado();
		empresa_id = entity.getEmpresa().getId();
	}
	
	public EnderecoDTO(Endereco entity, Empresa user) {
		this(entity);
		empresa_id = user.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(Long empresa_id) {
		this.empresa_id = empresa_id;
	}
}