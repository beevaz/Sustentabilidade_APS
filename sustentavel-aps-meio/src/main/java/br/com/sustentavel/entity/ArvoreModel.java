package br.com.sustentavel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="arvores")
public class ArvoreModel  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_arvore;
	@NotNull
	private String nome_arvore;
	@NotNull	
	private String nome_cientifico;
	
	//Getters
	public long getId_Arvore() {
		return id_arvore;
	}
	public String getNome_Arvore() {
		return nome_arvore;
	}
	public String getNome_Cientifico() {
		return nome_cientifico;
	}
	
	public void setId_Arvore(Long id_arvore) {
		this.id_arvore = id_arvore;
	}
	public void setNome_Arvore(String nome_arvore) {
		this.nome_arvore = nome_arvore;
	}
	public void setNome_Cientifico(String nome_cientifico) {
		this.nome_cientifico = nome_cientifico;
	}
}
