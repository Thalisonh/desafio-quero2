package com.quero2.pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quero2.pay.components.ViaCep;
import com.quero2.pay.entities.Endereco;

@Service
public class EnderecoService {

	@Autowired
	private ViaCep cepService;

	public Endereco getCep(String cep) {
		Endereco endereco = cepService.buscaEnderecoPorCep(cep);
		
		return endereco; 
	} 
}
