package com.fifa.FifaTeste.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fifa.FifaTeste.modal.Jogador;
import com.fifa.FifaTeste.modal.Time;
import com.fifa.FifaTeste.repository.JogadorRepository;
import com.fifa.FifaTeste.repository.TimeRepository;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository repository;
	

	@Autowired
	private TimeRepository repositoryTime;
	
	
	public List<Jogador> findAll(){
		return repository.findAll();
	}
	
	public Jogador findById(Long id) {
		return repository.findById(id)
				.map(resp->(resp))
				.orElse(null);
	}
	
	public List<Jogador> findByNome(String nome){
		return repository.findByNomeContainingIgnoreCase(nome);
	}
	
	public List<Jogador> findByIdade(int idade){
		return repository.findByIdade(idade);
	}
	
	public List<Jogador> findByOveral(int overal){
		return repository.findByOveral(overal);
	}
	
	public List<Jogador> findByOveralMaior(int overal){
		return repository.findByOveralGreaterThan(overal);
	}
	
	public List<Jogador> findByTime(Long idTime){
		Optional<Time> time = repositoryTime.findById(idTime);
			
		if(time.isPresent())
		return repository.findByTime(time.get());
		else {
			List<Jogador> notfound = new ArrayList<>();
			return notfound;
		}
	}
	
	public Jogador postJogador(Jogador jogador) {
		return repository.save(jogador);
	}
	
	public Jogador putJogador(Jogador jogador) {
		return repository.save(jogador);
	}
	
	public void deleteJogador(Long id) {
		repository.deleteById(id);
	}
	
}













