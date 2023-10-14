package br.com.viverprogramando.organizador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viverprogramando.organizador.model.UsuarioModel;
import br.com.viverprogramando.organizador.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public List<UsuarioModel> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<UsuarioModel> findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Override
	public UsuarioModel save(UsuarioModel usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

}
