package com.equipamentos;

import java.util.List;
import java.util.Set;

import com.equipamentos.dao.EquipamentoDAO;
import com.equipamentos.dao.GenericDAO;
import com.equipamentos.dao.InspetorDAO;
import com.equipamentos.facade.EquipamentoFacade;
import com.equipamentos.facade.InspetorFacade;
import com.equipamentos.facade.SerieTemporalFacade;
import com.equipamentos.model.Equipamento;
import com.equipamentos.model.Inspecao;
import com.equipamentos.model.Inspetor;
import com.equipamentos.model.SerieTemporal;

public class Main {
	public static void main(String[] args) {
		try {
			/*EquipamentoFacade facade = new EquipamentoFacade();
			Equipamento e = new Equipamento();
			e = facade.find(0);
			Set<Inspecao> inspecoes = e.getInspecoes();
			for (Inspecao i:inspecoes){
				System.out.println(i.getRelatorio());
			}
			Set<SerieTemporal> series = e.getSeriesTemporais();
			for (SerieTemporal s:series){
				System.out.println(s.getNomeSerie());
			}*/
			
			
			/*InspetorFacade facade = new InspetorFacade();
			Inspetor i = facade.findByCPF(3333333L);
			System.out.println(i.getNome());*/
			
			
			/*EquipamentoFacade facade = new EquipamentoFacade();
			List<Equipamento> e = facade.listarEquipamentosNaoInspecionados();
			for(Equipamento q:e){
				System.out.println(q.getNome());
			}*/
			
			
			/*EquipamentoFacade facade = new EquipamentoFacade();
			List<Equipamento> e = facade.listarEquipamentosInspecionadosPor(1L);
			for(Equipamento q:e){
				System.out.println(q.getNome());
			}*/
			
			
			SerieTemporalFacade facade = new SerieTemporalFacade();
			List<SerieTemporal> s = facade.listarSeriesTemporais(null, 0L);
			for(SerieTemporal st:s){
				System.out.println(st.getNomeSerie());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GenericDAO.fecharEntityManagerFactory();
		}
	}
}
