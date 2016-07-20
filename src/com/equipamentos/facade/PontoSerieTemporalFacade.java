package com.equipamentos.facade;

import com.equipamentos.dao.PontoSerieTemporalDAO;
import com.equipamentos.model.PontoSerieTemporal;

public class PontoSerieTemporalFacade {
	private PontoSerieTemporalDAO dao = new PontoSerieTemporalDAO();
	
	public void save(PontoSerieTemporal pontoSerieTemporal) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(pontoSerieTemporal);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void update(PontoSerieTemporal pontoSerieTemporal) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(pontoSerieTemporal);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw new Exception(e);
		}
	}

	public PontoSerieTemporal find(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			PontoSerieTemporal pontoSerieTemporal = dao.find(id);
			dao.commitAndCloseTransaction();
			return pontoSerieTemporal;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void delete(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			PontoSerieTemporal pontoSerieTemporal = dao.findReferenceOnly(id);
			dao.delete(pontoSerieTemporal);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}
