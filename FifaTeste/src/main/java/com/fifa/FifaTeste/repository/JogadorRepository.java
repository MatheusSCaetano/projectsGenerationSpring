package com.fifa.FifaTeste.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fifa.FifaTeste.modal.Jogador;
import com.fifa.FifaTeste.modal.Time;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long>{
	public List<Jogador> findByNomeContainingIgnoreCase(String nome);
	public List<Jogador> findByIdade(int idade);
	public List<Jogador> findByOveral(int overal);
	public List<Jogador> findByOveralGreaterThan(int overal);
	public List<Jogador> findByTime(Time time);
}
