package br.com.lincolnsrjr.business;

import br.com.lincolnsrjr.model.Carro;
import br.com.lincolnsrjr.model.Concessionaria;
import br.com.lincolnsrjr.repository.ConcessionariaRepository;

public class ConcessionariaBusiness {

	private ConcessionariaRepository concessionariaRepository;
	private CarroBusiness carroBussiness;

	public ConcessionariaBusiness() {
		concessionariaRepository = new ConcessionariaRepository();
		carroBussiness = new CarroBusiness();
	}

	public void retirarCarro(Carro carro) {
		carroBussiness.sairConcessionaria(carro);
	}

	public void mudarDonoConcessionaria(Concessionaria concessionaria, String novoDono) {
		concessionaria.setDono(novoDono);
		concessionariaRepository.atualizar(concessionaria);
	}

}
