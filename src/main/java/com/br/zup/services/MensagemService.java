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
	
	public Mensagem pegarMensagemPeloId(int id) {
		if (mensagemRepository.existsById(id)) {
			return mensagemRepository.findById(id).get();	
		}
		
		return null;
	}
	
	public void salvarMensagem(Mensagem mensagem) {
		mensagemRepository.save(mensagem);
	}
	
	public void atualizarMensagem(int id, Mensagem mensagem) {
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
