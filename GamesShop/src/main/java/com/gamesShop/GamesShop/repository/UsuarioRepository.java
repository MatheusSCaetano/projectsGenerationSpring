package com.gamesShop.GamesShop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamesShop.GamesShop.modal.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Optional<List<Usuario>> findByEmail(String email);
}
