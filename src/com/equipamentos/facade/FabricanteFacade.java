package com.equipamentos.facade;

import com.equipamentos.dao.FabricanteDAO;
import com.equipamentos.model.Fabricante;

public class FabricanteFacade {
	private FabricanteDAO dao = new FabricanteDAO();
	
	public void save(Fabricante fabricante) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(fabricante);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void update(Fabricante fabricante) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(fabricante);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw new Exception(e);
		}
	}

	public Fabricante find(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Fabricante fabricante = dao.find(id);
			dao.commitAndCloseTransaction();
			return fabricante;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void delete(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Fabricante fabricante = dao.findReferenceOnly(id);
			dao.delete(fabricante);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}
