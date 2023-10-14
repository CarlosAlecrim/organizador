package br.com.viverprogramando.organizador.service;

import java.util.List;
import java.util.Optional;

import br.com.viverprogramando.organizador.model.ProjetoModel;

public interface IProjetoService {
	
	List<ProjetoModel> findAll();
	
	Optional<ProjetoModel> findById(Long id);
	
	ProjetoModel save(ProjetoModel projeto);
	
	void deleteById(Long id);

}
