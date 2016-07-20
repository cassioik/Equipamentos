package com.equipamentos.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.equipamentos.model.Inspetor;

public class InspetorDAO extends GenericDAO<Integer, Inspetor> {

	public InspetorDAO() {
		super(Inspetor.class);
	}

	public Inspetor findByCPF(Long cpf) {
		String sql = "SELECT i FROM Inspetor i WHERE i.cpf = :cpf";
		Query query = super.getEntityManager().createQuery(sql);
		query.setParameter("cpf", cpf);
		try{
			Inspetor retorno = (Inspetor)query.getSingleResult();
			return retorno;
		}catch(NoResultException nr){
			return null;
		}
	}

}
