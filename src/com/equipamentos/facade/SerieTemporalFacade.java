package com.equipamentos.facade;

import com.equipamentos.dao.SerieTemporalDAO;
import com.equipamentos.model.SerieTemporal;

public class SerieTemporalFacade {
private SerieTemporalDAO dao = new SerieTemporalDAO();
	
	public void save(SerieTemporal serieTemporal) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(serieTemporal);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void update(SerieTemporal serieTemporal) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(serieTemporal);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw new Exception(e);
		}
	}

	public SerieTemporal find(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			SerieTemporal serieTemporal = dao.find(id);
			dao.commitAndCloseTransaction();
			return serieTemporal;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void delete(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			SerieTemporal serieTemporal = dao.findReferenceOnly(id);
			dao.delete(serieTemporal);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}
