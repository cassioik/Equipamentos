package com.equipamentos.dao;

import java.util.List;

import javax.persistence.Query;

import com.equipamentos.model.Equipamento;

public class EquipamentoDAO extends GenericDAO<Integer, Equipamento>{

	public EquipamentoDAO() {
		super(Equipamento.class);
	}
	
	public List<Equipamento> listarEquipamentosNaoInspecionados(){
		String sql = "SELECT DISTINCT e FROM Inspecao i INNER JOIN Equipamento e ON i.equipamento.id <> e.id";
		Query query = super.getEntityManager().createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Equipamento> retorno = query.getResultList();
		return retorno;
	}
}
