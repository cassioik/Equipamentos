package com.equipamentos.facade;

import com.equipamentos.dao.InspetorDAO;
import com.equipamentos.model.Inspetor;

public class InspetorFacade {
	private InspetorDAO dao = new InspetorDAO();

	public void save(Inspetor inspetor) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(inspetor);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void update(Inspetor inspetor) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(inspetor);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw new Exception(e);
		}
	}

	public Inspetor find(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Inspetor inspetor = dao.find(id);
			dao.commitAndCloseTransaction();
			return inspetor;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void delete(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Inspetor inspetor = dao.findReferenceOnly(id);
			dao.delete(inspetor);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public Inspetor findByCPF(Long cpf) throws Exception {
		try {
			dao.beginTransaction();
			Inspetor inspetor = dao.findByCPF(cpf);
			dao.commitAndCloseTransaction();
			return inspetor;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}
