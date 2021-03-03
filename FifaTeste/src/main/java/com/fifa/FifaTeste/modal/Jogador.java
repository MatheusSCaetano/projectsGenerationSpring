package com.fifa.FifaTeste.modal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fifa.FifaTeste.util.PosicoesAceitas;

@Entity
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private int idade;
	
	@Enumerated(EnumType.STRING)
	private PosicoesAceitas posicao;
	
	@NotNull
	private int overal;
	
	@ManyToOne
	@JsonIgnoreProperties("jogadores")
	private Time time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getOveral() {
		return overal;
	}

	public void setOveral(int overal) {
		this.overal = overal;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public PosicoesAceitas getPosicao() {
		return posicao;
	}

	public void setPosicao(PosicoesAceitas posicao) {
		this.posicao = posicao;
	}
	
	
}
