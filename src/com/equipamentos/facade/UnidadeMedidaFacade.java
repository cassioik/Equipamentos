package com.equipamentos.facade;

import com.equipamentos.dao.UnidadeMedidaDAO;
import com.equipamentos.model.UnidadeMedida;

public class UnidadeMedidaFacade {
private UnidadeMedidaDAO dao = new UnidadeMedidaDAO();
	
	public void save(UnidadeMedida unidadeMedida) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(unidadeMedida);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void update(UnidadeMedida unidadeMedida) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(unidadeMedida);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw new Exception(e);
		}
	}

	public UnidadeMedida find(String id) throws Exception {
		try {
			dao.beginTransaction();
			UnidadeMedida unidadeMedida = dao.find(id);
			dao.commitAndCloseTransaction();
			return unidadeMedida;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void delete(String id) throws Exception {
		try {
			dao.beginTransaction();
			UnidadeMedida unidadeMedida = dao.findReferenceOnly(id);
			dao.delete(unidadeMedida);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}
