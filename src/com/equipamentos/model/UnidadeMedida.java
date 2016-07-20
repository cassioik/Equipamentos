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
@Table(name="unidademedida")
public class UnidadeMedida {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="unidademedida_id", updatable=false)
	private String id;
	
	@Column(length=45, nullable=false)
	private String nomeUnidade;
	
	@OneToMany(mappedBy="unidadeMedida")
	private List<SerieTemporal> seriesTemporais;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomeUnidade() {
		return nomeUnidade;
	}
	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}
	public List<SerieTemporal> getSeriesTemporais() {
		return seriesTemporais;
	}
	public void setSeriesTemporais(List<SerieTemporal> seriesTemporais) {
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
		UnidadeMedida other = (UnidadeMedida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}