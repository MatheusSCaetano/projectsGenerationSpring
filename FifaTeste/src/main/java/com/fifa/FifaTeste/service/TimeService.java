package com.fifa.FifaTeste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fifa.FifaTeste.modal.Time;
import com.fifa.FifaTeste.repository.TimeRepository;

@Service
public class TimeService {

	@Autowired
	private TimeRepository repository;
	
	public List<Time> findAll(){
		return repository.findAll();
	}
	
	public Time findById(Long id) {
		return repository.findById(id)
				.map(resp -> (resp))
				.orElse(null);
	}
	
	public List<Time> findByNome(String nome){
		return repository.findByNomeContainingIgnoreCase(nome);
	}
	
	public Time postTime(Time time) {
		return repository.save(time);
	}
	
	public Time putTime(Time time) {
		return repository.save(time);
	}
	
	public void deleteTime(Long id) {
		repository.deleteById(id);
	}
	
}














