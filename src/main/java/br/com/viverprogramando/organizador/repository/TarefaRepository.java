package br.com.viverprogramando.organizador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viverprogramando.organizador.model.TarefaModel;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, Long>{

}
