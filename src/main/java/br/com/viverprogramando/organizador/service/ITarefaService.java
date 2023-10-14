package br.com.viverprogramando.organizador.service;

import java.util.List;
import java.util.Optional;

import br.com.viverprogramando.organizador.model.TarefaModel;

public interface ITarefaService {
	
	List<TarefaModel> findAll();
	
	Optional <TarefaModel> findById(Long Id);
	
	TarefaModel save(TarefaModel tarefa);
	
	void deleteById(Long id);
}
