package com.fifa.FifaTeste.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fifa.FifaTeste.modal.Time;
import com.fifa.FifaTeste.service.TimeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/times")
public class TimeController {

	@Autowired
	private TimeService service;
	
	@GetMapping("/full")
	public ResponseEntity<List<Time>> findAll(){
		return new ResponseEntity<List<Time>>(
				service.findAll(),
				HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Time> findById(@PathVariable Long id){
		return new ResponseEntity<Time>(
				service.findById(id),
				HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Time>> findByNome(@RequestParam String nome){
		return new ResponseEntity<List<Time>>(
				service.findByNome(nome),
				HttpStatus.ACCEPTED
				);
	}
	
	@PostMapping 
	public ResponseEntity<Time> postTime(@RequestBody Time time){
		return new ResponseEntity<Time>(
				service.postTime(time),
				HttpStatus.CREATED
				);
	}
	
	@PutMapping 
	public ResponseEntity<Time> putEntity(@RequestBody Time time){
		return new ResponseEntity<Time>(
				service.putTime(time),
				HttpStatus.OK
				);
	}
	
	@DeleteMapping("/deletarTime/{id}")
	public void deleteTime(@PathVariable Long id) {
		service.deleteTime(id);
	}
	
}