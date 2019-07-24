package com.br.zup.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.exceptions.MensagemNaoEncontradaException;
import com.br.zup.models.Mensagem;
import com.br.zup.repositories.MensagemRepository;

@Service
public class MensagemService {
	@Autowired
	private MensagemRepository mensagemRepository;
	
	public Iterable<Mensagem> pegarMensagens() {
		return mensagemRepository.findAll();
	}
	
	public Mensagem pegarMensagemPeloId(int id) {
		return mensagemRepository.findById(id).get();	
	}
	
	public void salvarMensagem(Mensagem mensagem) {
		mensagemRepository.save(mensagem);
	}
	
	public void atualizarMensagem(int id, Mensagem mensagem) {
		Optional<Mensagem> optionalMensagem = mensagemRepository.findById(id);
		if (!optionalMensagem.isPresent()) {
			throw new MensagemNaoEncontradaException("Não há mensagens com esse id");
		}
		
		mensagem.setId(id);
		mensagemRepository.save(mensagem);
	}
	
	public void apagarMensagem(int id) {
		mensagemRepository.deleteById(id);
	}
	
	public long quantidadeDeMensagens() {
		return mensagemRepository.count();
	}
}
