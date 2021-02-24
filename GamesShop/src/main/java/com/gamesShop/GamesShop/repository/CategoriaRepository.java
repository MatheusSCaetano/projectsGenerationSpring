package com.gamesShop.GamesShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamesShop.GamesShop.modal.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria> findAllByTipoContainingIgnoreCase(String tipo);
	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
}
