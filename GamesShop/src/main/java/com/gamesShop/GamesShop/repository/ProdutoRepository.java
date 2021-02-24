package com.gamesShop.GamesShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamesShop.GamesShop.modal.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	public List<Produto> findAllByFabricanteContainingIgnoreCase(String fabricante);
	public List<Produto> findByValorLessThan(Double valor);
}
