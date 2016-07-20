package com.equipamentos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="inspetor")
public class Inspetor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inspetor_id", updatable=false)
	private Integer id;
	
	@Column(length=45, nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Long cpf;
	
	@OneToMany(mappedBy="inspetor")
	private List<Inspecao> Inspecoes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public List<Inspecao> getInspecoes() {
		return Inspecoes;
	}
	public void setInspecoes(List<Inspecao> inspecoes) {
		Inspecoes = inspecoes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inspetor other = (Inspetor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
