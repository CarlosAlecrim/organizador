package br.com.viverprogramando.organizador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viverprogramando.organizador.model.ProjetoModel;
import br.com.viverprogramando.organizador.repository.ProjetoRepository;

@Service
public class ProjetoServiceImpl implements IProjetoService {

	private final ProjetoRepository projetoRepository;
	
	@Autowired
	public ProjetoServiceImpl(ProjetoRepository projetoRepository) {
		// TODO Auto-generated constructor stub
		this.projetoRepository = projetoRepository;
	}
	
	@Override
	public List<ProjetoModel> findAll() {
		// TODO Auto-generated method stub
		return projetoRepository.findAll();
	}

	@Override
	public Optional<ProjetoModel> findById(Long id) {
		// TODO Auto-generated method stub
		return projetoRepository.findById(id);
	}

	@Override
	public ProjetoModel save(ProjetoModel projeto) {
		// TODO Auto-generated method stub
		return projetoRepository.save(projeto);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		projetoRepository.deleteById(id);
	}

}
