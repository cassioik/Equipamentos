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
	
	public List<Equipamento> listarEquipamentosInspecionadosPor(Long idInspetor){
		String sql = "SELECT DISTINCT e FROM Equipamento e INNER JOIN Inspecao i ON i.equipamento.id = e.id INNER JOIN Inspetor ins ON i.inspetor.id = ins.id WHERE ins.id = :idInspetor";
		Query query = super.getEntityManager().createQuery(sql);
		query.setParameter("idInspetor", idInspetor);
		
		@SuppressWarnings("unchecked")
		List<Equipamento> retorno = query.getResultList();
		return retorno;
	}
}
