package br.com.viverprogramando.organizador.service;

import java.util.List;
import java.util.Optional;

import br.com.viverprogramando.organizador.model.UsuarioModel;

public interface IUsuarioService {
	
	List<UsuarioModel> findAll();
	
	Optional<UsuarioModel> findById(Long id);
	
	UsuarioModel save (UsuarioModel usuario);
	
	void deleteById(Long id);
}
