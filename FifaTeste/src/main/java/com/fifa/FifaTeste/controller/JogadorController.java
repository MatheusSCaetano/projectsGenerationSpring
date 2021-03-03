package com.fifa.FifaTeste.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fifa.FifaTeste.modal.Jogador;
import com.fifa.FifaTeste.service.JogadorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/jogadores")
public class JogadorController {

	@Autowired
	private JogadorService service;
	
	@GetMapping("/full")
	public ResponseEntity<List<Jogador>> findAll(){
		return new ResponseEntity<List<Jogador>>(
				service.findAll(),
				HttpStatus.OK
				);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Jogador>> findByNome(@PathVariable String nome){
		return new ResponseEntity<List<Jogador>>(
				service.findByNome(nome),
				HttpStatus.OK
				);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogador> findById(@PathVariable Long id){
		return new ResponseEntity<Jogador>(
				service.findById(id),
				HttpStatus.OK
				);
	}
	
	@GetMapping("/idade/{idade}")
	public ResponseEntity<List<Jogador>> findByIdade(@PathVariable int idade){
		return new ResponseEntity<List<Jogador>>(
				service.findByIdade(idade),
				HttpStatus.OK
				);
	}
	
	@GetMapping("/overal/{overal}")
	public ResponseEntity<List<Jogador>> findByOveral(@PathVariable int overal){
		return new ResponseEntity<List<Jogador>>(
				service.findByOveral(overal),
				HttpStatus.OK
				);
	}
	
	@GetMapping("/overalMore/{overalMore}")
	public ResponseEntity<List<Jogador>> findByOveralMore(@PathVariable int overalMore){
		return new ResponseEntity<List<Jogador>>(
				service.findByOveralMaior(overalMore),
				HttpStatus.OK
				);
	}
	
	@GetMapping("/time")
	public ResponseEntity<List<Jogador>> findByTime(@RequestParam Long idTime){
		
				if(service.findByTime(idTime).size()<1) {
					return  new ResponseEntity<List<Jogador>>(HttpStatus.NOT_FOUND);
				}
				else {
					return new ResponseEntity<List<Jogador>>(service.findByTime(idTime), HttpStatus.NOT_FOUND);
				}
						
	}
	
	@PostMapping
	public ResponseEntity<Jogador> postJogador(@Valid @RequestBody Jogador jogador){
		return new ResponseEntity<Jogador>(
				service.postJogador(jogador),
				HttpStatus.CREATED
				);
	}
	
	@PutMapping
	public ResponseEntity<Jogador> putJogador(@Valid @RequestBody Jogador jogador){
		return new ResponseEntity<Jogador>(
				service.putJogador(jogador),
				HttpStatus.OK
				);
	}
	
	@DeleteMapping
	public void deletJogador(Long id) {
		service.deleteJogador(id);
	}
	
}