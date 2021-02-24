package com.gamesShop.GamesShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamesShop.GamesShop.modal.Produto;
import com.gamesShop.GamesShop.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAllProduto(){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findByIdProduto(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nomeProduto/{nome}")
	public ResponseEntity<List<Produto>> findByNomeProduto(@PathVariable String nome){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/nomeFabricante/{fabricante}")
	public ResponseEntity<List<Produto>> findByFabricanteProduto(@PathVariable String fabricante){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByFabricanteContainingIgnoreCase(fabricante));
	}
	
	@GetMapping("/valorProduto/{valor}")
	public ResponseEntity<List<Produto>> findByValor(@PathVariable Double valor){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findByValorLessThan(valor));
	}
	
	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deleteProduto(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
