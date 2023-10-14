package br.com.viverprogramando.organizador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viverprogramando.organizador.model.AtividadeModel;

@Repository
public interface AtividadeRepository extends  JpaRepository<AtividadeModel, Long>{

}
