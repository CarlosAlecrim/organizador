package br.com.viverprogramando.organizador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viverprogramando.organizador.model.AtividadeModel;
import br.com.viverprogramando.organizador.repository.AtividadeRepository;

@Service
public class AtividadeServiceImpl implements IAtividadeService{
	
	private final AtividadeRepository atividadeRepository;
	
	@Autowired
	public AtividadeServiceImpl(AtividadeRepository atividadeRepository) {
		// TODO Auto-generated constructor stub
		this.atividadeRepository = atividadeRepository;
	}
	
	@Override
	public List<AtividadeModel> findAll() {
		// TODO Auto-generated method stub
		return atividadeRepository.findAll();
	}

	@Override
	public Optional<AtividadeModel> findById(Long id) {
		// TODO Auto-generated method stub
		return atividadeRepository.findById(id);
	}

	@Override
	public AtividadeModel save(AtividadeModel atividade) {
		// TODO Auto-generated method stub
		return atividadeRepository.save(atividade);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		atividadeRepository.deleteById(id);
		
	}

}
