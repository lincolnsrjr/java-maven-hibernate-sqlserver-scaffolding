package br.com.lincolnsrjr.business;

import br.com.lincolnsrjr.model.Carro;
import br.com.lincolnsrjr.repository.CarroRepository;

public class CarroBusiness {

	private CarroRepository carroRepository;
	
	public CarroBusiness() {
		carroRepository = new CarroRepository();
	}

	public void sairConcessionaria(Carro carro) {
		carro.setConcessionaria(null);
		carroRepository.atualizar(carro);
	}
}
