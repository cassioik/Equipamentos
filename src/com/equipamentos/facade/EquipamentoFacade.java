package com.equipamentos.facade;

import java.util.List;

import com.equipamentos.dao.EquipamentoDAO;
import com.equipamentos.model.Equipamento;

public class EquipamentoFacade {
	private EquipamentoDAO dao = new EquipamentoDAO();
	
	public void save(Equipamento equipamento) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(equipamento);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void update(Equipamento equipamento) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(equipamento);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw new Exception(e);
		}
	}

	public Equipamento find(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Equipamento equipamento = dao.find(id);
			dao.commitAndCloseTransaction();
			return equipamento;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	public void delete(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Equipamento equipamento = dao.findReferenceOnly(id);
			dao.delete(equipamento);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public List<Equipamento> listarEquipamentosNaoInspecionados(){
		try {
			dao.beginTransaction();
			List<Equipamento> equipamentos = dao.listarEquipamentosNaoInspecionados();
			dao.commitAndCloseTransaction();
			return equipamentos;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}
