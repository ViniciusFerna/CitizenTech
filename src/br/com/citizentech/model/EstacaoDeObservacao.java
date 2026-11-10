package br.com.citizentech.model;

public class EstacaoDeObservacao extends ComponenteTerritorial {

		private SensorChuva sensorChuva;
		
		private SensorNivelDoRio sensorRio;
		
		private SensorUmidade sensorUmidade;
	
	public EstacaoDeObservacao(int id, String nome, String regiao) {
		super(id, nome, regiao);
	}
	

	public SensorChuva getSensorChuva() {
		return sensorChuva;
	}


	public SensorNivelDoRio getSensorRio() {
		return sensorRio;
	}


	public SensorUmidade getSensorUmidade() {
		return sensorUmidade;
	}


	@Override
	public StatusDeAlerta verificarStatusDeAlerta() {
		// TODO Auto-generated method stub
		return null;
	}

}
