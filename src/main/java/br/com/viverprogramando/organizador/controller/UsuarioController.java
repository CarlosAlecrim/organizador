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

import br.com.viverprogramando.organizador.model.UsuarioModel;
import br.com.viverprogramando.organizador.service.ProjetoServiceImpl;
import br.com.viverprogramando.organizador.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private final UsuarioServiceImpl usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioServiceImpl usuarioService) {
		// TODO Auto-generated constructor stub
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<UsuarioModel> listUsuarios() {
		
		return usuarioService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> getUsuario(@PathVariable Long id) {
		
		return usuarioService.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(()-> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<UsuarioModel> createUsuario(@RequestBody UsuarioModel usuario) {
		UsuarioModel savedUsuario = usuarioService.save(usuario);
		
		return ResponseEntity.ok(savedUsuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioModel> updateUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
		
		if(!usuarioService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuario.setId(id);
		
		UsuarioModel updatedUsuario = usuarioService.save(usuario);
		
		return ResponseEntity.ok(updatedUsuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
		
		if(!usuarioService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		usuarioService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
