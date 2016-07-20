package com.equipamentos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="serietemporal")
public class SerieTemporal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serietemporal_id", updatable=false)
	private Long id;
	
	@Column(length=45, nullable=false)
	private String nomeSerie;
	
	@ManyToOne 
	@JoinColumn(name = "unidademedida_id") 
	private UnidadeMedida unidadeMedida;
	
	@ManyToOne 
	@JoinColumn(name = "equipamento_id")
	private Equipamento equipamento;
	
	@OneToMany(mappedBy="serietemporal") 
	private List<PontoSerieTemporal> pontos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeSerie() {
		return nomeSerie;
	}
	public void setNomeSerie(String nomeSerie) {
		this.nomeSerie = nomeSerie;
	}
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public List<PontoSerieTemporal> getPontos() {
		return pontos;
	}
	public void setPontos(List<PontoSerieTemporal> pontos) {
		this.pontos = pontos;
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
		SerieTemporal other = (SerieTemporal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
