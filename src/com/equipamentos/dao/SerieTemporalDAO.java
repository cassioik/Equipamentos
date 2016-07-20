package com.equipamentos.dao;

import java.util.List;

import javax.persistence.Query;

import com.equipamentos.model.SerieTemporal;

public class SerieTemporalDAO extends GenericDAO<Integer, SerieTemporal>{

	public SerieTemporalDAO() {
		super(SerieTemporal.class);
	}
	
	public List<SerieTemporal> listarSeriesTemporais(String unidadeMedidaID, Long idEquipamento){
		String sql = null;
		Query query;
		if (unidadeMedidaID != null && idEquipamento != null){
			sql = "SELECT s FROM SerieTemporal s WHERE s.equipamento.id = :idEquipamento AND s.unidadeMedida.id = :unidadeMedidaID";
			query = super.getEntityManager().createQuery(sql);
			query.setParameter("unidadeMedidaID", unidadeMedidaID);
			query.setParameter("idEquipamento", idEquipamento);
		} else if (unidadeMedidaID == null && idEquipamento != null){
			sql = "SELECT s FROM SerieTemporal s WHERE s.equipamento.id = :idEquipamento";
			query = super.getEntityManager().createQuery(sql);
			query.setParameter("idEquipamento", idEquipamento);
		} else if (unidadeMedidaID != null && idEquipamento == null){
			sql = "SELECT s FROM SerieTemporal s WHERE s.unidadeMedida.id = :unidadeMedidaID";
			query = super.getEntityManager().createQuery(sql);
			query.setParameter("unidadeMedidaID", unidadeMedidaID);
		} else {
			sql = "SELECT s FROM SerieTemporal s";
			query = super.getEntityManager().createQuery(sql);
		}
		
		@SuppressWarnings("unchecked")
		List<SerieTemporal> retorno = query.getResultList();
		return retorno;
		
	}
	
}
