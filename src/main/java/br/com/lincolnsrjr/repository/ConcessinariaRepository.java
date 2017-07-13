package br.com.lincolnsrjr.repository;

import java.util.List;

import br.com.lincolnsrjr.model.Concessionaria;

public class ConcessinariaRepository extends AbstractRepository<Concessionaria>{
	
	public ConcessinariaRepository(){
		super(Concessionaria.class);
	}
		
	public List<Concessionaria> getConcessionariaPorDono(String dono){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM CONCESSIONARIAS WHERE DES_DONO = "+dono);
		return selecionar(sb);
	}
	
	public void deletarConcessionariasPorDono(String dono){
		deletar(getConcessionariaPorDono(dono));
	}

}
