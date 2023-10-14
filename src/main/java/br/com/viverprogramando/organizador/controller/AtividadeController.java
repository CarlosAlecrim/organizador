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

import br.com.viverprogramando.organizador.model.AtividadeModel;
import br.com.viverprogramando.organizador.service.AtividadeServiceImpl;

@RestController
@RequestMapping("/api/atividades")
public class AtividadeController {

	private final AtividadeServiceImpl atividadeService;
	
	@Autowired
	public AtividadeController(AtividadeServiceImpl atividadeService) {
		// TODO Auto-generated constructor stub
		this.atividadeService = atividadeService;
	}
	
	@GetMapping
	public List<AtividadeModel> listAtividades(){
		 
		return atividadeService.findAll();
	}  
	
	@GetMapping("/{id}")
	public ResponseEntity<AtividadeModel> getAtividade(@PathVariable Long id){
		
		return atividadeService.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<AtividadeModel> createAtividade(@RequestBody AtividadeModel atividade){
		
		AtividadeModel createdAtividade = atividadeService.save(atividade);
		
		
		return ResponseEntity.ok(createdAtividade);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AtividadeModel> updateAtividade(@PathVariable Long id, @RequestBody AtividadeModel atividade){
		
		if(!atividadeService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		atividade.setId(id);
		
		AtividadeModel updatedAtividade = atividadeService.save(atividade);
		
		return ResponseEntity.ok(updatedAtividade);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAtividade(Long id){
		
		if(!atividadeService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		atividadeService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	 
	 
}
