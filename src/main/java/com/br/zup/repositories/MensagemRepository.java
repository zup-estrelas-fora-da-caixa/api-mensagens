package com.br.zup.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.models.Mensagem;

@Repository
public interface MensagemRepository extends CrudRepository<Mensagem, Integer>{

}
