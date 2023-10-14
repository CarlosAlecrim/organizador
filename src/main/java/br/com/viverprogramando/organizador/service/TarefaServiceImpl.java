package br.com.viverprogramando.organizador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viverprogramando.organizador.model.TarefaModel;
import br.com.viverprogramando.organizador.repository.TarefaRepository;

@Service
public class TarefaServiceImpl implements ITarefaService {

	private final TarefaRepository tarefaRepository;
	
	@Autowired
	public TarefaServiceImpl(TarefaRepository tarefaRepository) {
		// TODO Auto-generated constructor stub
		this.tarefaRepository = tarefaRepository;
	}
	
	@Override
	public List<TarefaModel> findAll() {
		// TODO Auto-generated method stub
		return tarefaRepository.findAll();
	}

	@Override
	public Optional<TarefaModel> findById(Long Id) {
		// TODO Auto-generated method stub
		return tarefaRepository.findById(Id);
	}

	@Override
	public TarefaModel save(TarefaModel tarefa) {
		// TODO Auto-generated method stub
		return tarefaRepository.save(tarefa);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		tarefaRepository.deleteById(id);
	}

}
