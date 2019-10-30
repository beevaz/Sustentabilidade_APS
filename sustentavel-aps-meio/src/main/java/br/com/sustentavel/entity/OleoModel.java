package br.com.sustentavel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="oleo")
public class OleoModel  {

	@Id
	@NotNull
	private long id_oleo;
	@NotNull
	private String regiao;
	@NotNull	
	private String endereco;
	
	//Getters
	public long getId_Oleo() {
		return id_oleo;
	}
	public String getRegiao() {
		return regiao;
	}
	public String getEndereco() {
		return endereco;
	}
	
	public void setId_Oleo(Long id_oleo) {
		this.id_oleo = id_oleo;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
