package br.com.viverprogramando.organizador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.viverprogramando.organizador.model.TarefaModel;
import br.com.viverprogramando.organizador.service.TarefaServiceImpl;


@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

	private final TarefaServiceImpl projetoService;
	
	@Autowired
	public TarefaController(TarefaServiceImpl projetoService) {
		// TODO Auto-generated constructor stub
		this.projetoService = projetoService;
	}
	
	@GetMapping
	public List<TarefaModel> listTarefas() {
		
		return projetoService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TarefaModel> getTarefa(@PathVariable Long id) {
		
		return projetoService.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(()-> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<TarefaModel> createUsuario(@RequestBody TarefaModel projeto) {
		TarefaModel savedTarefa = projetoService.save(projeto);
		
		return ResponseEntity.ok(savedTarefa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TarefaModel> updateTarefa(@PathVariable Long id, @RequestBody TarefaModel projeto) {
		
		if(!projetoService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		projeto.setId(id);
		
		TarefaModel updatedTarefa = projetoService.save(projeto);
		
		return ResponseEntity.ok(updatedTarefa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTarefa(@PathVariable Long id) {
		
		if(!projetoService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		projetoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
