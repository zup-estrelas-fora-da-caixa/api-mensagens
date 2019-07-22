package com.br.zup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.models.Mensagem;
import com.br.zup.repositories.MensagemRepository;

@Service
public class MensagemService {
	@Autowired
	private MensagemRepository mensagemRepository;
	
	public Iterable<Mensagem> pegarMensagens() {
		return mensagemRepository.findAll();
	}
	
	public void salvarMensagem(Mensagem mensagem) {
		mensagemRepository.save(mensagem);
	}
	
	public long quantidadeDeMensagens() {
		return mensagemRepository.count();
	}
}
