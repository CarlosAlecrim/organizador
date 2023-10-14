package br.com.viverprogramando.organizador.service;

import java.util.List;
import java.util.Optional;

import br.com.viverprogramando.organizador.model.AtividadeModel;

public interface IAtividadeService {
	
	List<AtividadeModel> findAll();
	
	Optional<AtividadeModel>findById(Long id);
	
	AtividadeModel save(AtividadeModel atividade);
	
	void deleteById(Long id);

}
