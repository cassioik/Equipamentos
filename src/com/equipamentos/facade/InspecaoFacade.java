package com.equipamentos.facade;

import com.equipamentos.dao.InspecaoDAO;
import com.equipamentos.model.Inspecao;

public class InspecaoFacade {
	private InspecaoDAO dao = new InspecaoDAO();

	public void save(Inspecao inspecao) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(inspecao);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void update(Inspecao inspecao) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(inspecao);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw new Exception(e);
		}
	}

	public Inspecao find(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Inspecao inspecao = dao.find(id);
			dao.commitAndCloseTransaction();
			return inspecao;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void delete(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Inspecao inspecao = dao.findReferenceOnly(id);
			dao.delete(inspecao);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}
