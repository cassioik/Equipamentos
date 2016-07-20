package com.equipamentos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pontoserietemporal")
public class PontoSerieTemporal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pontoserietemporal_id", updatable=false)
	private Long id;
	
	@Column(nullable=false)
	private Date datahoramedicao;
	
	@ManyToOne 
	@JoinColumn(name = "serietemporal_id") 
	private SerieTemporal serietemporal;
	
	@Column(nullable=false)
	private Double valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatahoramedicao() {
		return datahoramedicao;
	}
	public void setDatahoramedicao(Date datahoramedicao) {
		this.datahoramedicao = datahoramedicao;
	}
	public SerieTemporal getSerietemporal() {
		return serietemporal;
	}
	public void setSerietemporal(SerieTemporal serietemporal) {
		this.serietemporal = serietemporal;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
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
		PontoSerieTemporal other = (PontoSerieTemporal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
