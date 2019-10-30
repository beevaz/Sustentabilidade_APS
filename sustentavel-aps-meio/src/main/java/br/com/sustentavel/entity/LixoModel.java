package br.com.sustentavel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="lixo")
public class LixoModel  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_lixo;
	@NotNull
	private String endereco;
	@NotNull	
	private String regiao;
	@NotNull	
	private String materiais;
	
	//Getters
	public long getId_Lixo() {
		return id_lixo;
	}
	public String getRegiao() {
		return regiao;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getMateriais() {
		return materiais;
	}
	
	public void setId_Lixo(Long id_lixo) {
		this.id_lixo = id_lixo;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setMateriais(String materiais) {
		this.materiais = materiais;
	}
}
