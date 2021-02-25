package com.gamesShop.GamesShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamesShop.GamesShop.modal.Usuario;
import com.gamesShop.GamesShop.repository.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAllUsuario(){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findByIdUsuario(@PathVariable Long id){
		return repository.findById(id)
				.map(resp->ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nameUser/{nome}")
	public ResponseEntity<List<Usuario>> findByNomeUsuario(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByNomeContainingIgnoreCase(name));
	}
	
	@GetMapping("/sobrenomeUser/{sobrenome}")
	public ResponseEntity<List<Usuario>> findBySobrenome(@PathVariable String sobrenome){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllBySobrenomeContainingIgnoreCase(sobrenome));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> postUsuario(@Validated @RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> putUsuario(@Validated @RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
