package com.fifa.FifaTeste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fifa.FifaTeste.modal.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
	public List<Time> findByNomeContainingIgnoreCase(String nome);
}
