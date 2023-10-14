package br.com.viverprogramando.organizador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viverprogramando.organizador.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {

}
