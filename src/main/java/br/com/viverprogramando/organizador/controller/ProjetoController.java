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

import br.com.viverprogramando.organizador.model.ProjetoModel;
import br.com.viverprogramando.organizador.model.UsuarioModel;
import br.com.viverprogramando.organizador.service.ProjetoServiceImpl;
import br.com.viverprogramando.organizador.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

	private final ProjetoServiceImpl projetoService;
	
	@Autowired
	public ProjetoController(ProjetoServiceImpl projetoService) {
		// TODO Auto-generated constructor stub
		this.projetoService = projetoService;
	}
	
	@GetMapping
	public List<ProjetoModel> listProjetos() {
		
		return projetoService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProjetoModel> getProjeto(@PathVariable Long id) {
		
		return projetoService.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(()-> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<ProjetoModel> createUsuario(@RequestBody ProjetoModel projeto) {
		ProjetoModel savedProjeto = projetoService.save(projeto);
		
		return ResponseEntity.ok(savedProjeto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProjetoModel> updateProjeto(@PathVariable Long id, @RequestBody ProjetoModel projeto) {
		
		if(!projetoService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		projeto.setId(id);
		
		ProjetoModel updatedProjeto = projetoService.save(projeto);
		
		return ResponseEntity.ok(updatedProjeto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProjeto(@PathVariable Long id) {
		
		if(!projetoService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		projetoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
