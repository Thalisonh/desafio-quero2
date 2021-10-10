package com.quero2.pay.components;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quero2.pay.entities.Endereco;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface ViaCep {
	
	@GetMapping("{cep}/json")
    Endereco buscaEnderecoPorCep(@PathVariable("cep") String cep);

}