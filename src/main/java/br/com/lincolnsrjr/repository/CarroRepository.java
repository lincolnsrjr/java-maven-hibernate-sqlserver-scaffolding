package br.com.lincolnsrjr.repository;

import java.util.List;

import br.com.lincolnsrjr.model.Carro;
import br.com.lincolnsrjr.model.Concessionaria;

public class CarroRepository extends AbstractRepository<Carro>{
	
	public CarroRepository(){
		super(Carro.class);
	}
	
	public List<Carro> getCarrosPorConcessionaria(Concessionaria concessionaria){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM CARROS WHERE NUM_CONCESSIONARIA = "+concessionaria.getId());
		return selecionar(sb);
	}

}
