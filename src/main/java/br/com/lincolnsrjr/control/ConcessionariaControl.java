package br.com.lincolnsrjr.control;

import br.com.lincolnsrjr.business.ConcessionariaBusiness;
import br.com.lincolnsrjr.model.Carro;

public class ConcessionariaControl {

	private ConcessionariaBusiness business;
	
	public ConcessionariaControl(){
		business = new ConcessionariaBusiness();
	}
	
	public void retirarCarroDaConcessionaria(Carro carro){
		business.retirarCarro(carro);
	}
	
}
