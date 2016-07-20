package com.equipamentos.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipamento")
public class Equipamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="equipamento_id", updatable=false)
	private Long id;
	
	@Column(length=45, nullable=false)
	private String nome;
	
	@Column(length=100, nullable=false)
	private String descricao;
	
	@ManyToMany
	@JoinTable(name="equipamento_fabricante",
			  joinColumns={@JoinColumn(name="equipamento_id", referencedColumnName="equipamento_id")},
			  inverseJoinColumns={@JoinColumn(name="fabricante_id", referencedColumnName="fabricante_id")})
	private List<Fabricante> fabricantes;
	
	@OneToMany(mappedBy="equipamento", fetch=FetchType.EAGER)
	private Set<Inspecao> inspecoes;
	
	@OneToMany(mappedBy="equipamento", fetch=FetchType.EAGER)
	private Set<SerieTemporal> seriesTemporais;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	public Set<Inspecao> getInspecoes() {
		return inspecoes;
	}
	public void setInspecoes(Set<Inspecao> inspecoes) {
		this.inspecoes = inspecoes;
	}
	public Set<SerieTemporal> getSeriesTemporais() {
		return seriesTemporais;
	}
	public void setSeriesTemporais(Set<SerieTemporal> seriesTemporais) {
		this.seriesTemporais = seriesTemporais;
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
		Equipamento other = (Equipamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
