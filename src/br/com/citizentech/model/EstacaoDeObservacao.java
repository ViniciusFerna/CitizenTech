package br.com.citizentech.model;

import java.util.ArrayList;

public class EstacaoDeObservacao extends ComponenteTerritorial {

		private SensorChuva sensorChuva;
		
		private SensorNivelDoRio sensorRio;
		
		private SensorUmidade sensorUmidade;
		
		private ArrayList<ArrayList<Double>> leituras = new ArrayList<>();
	
	public EstacaoDeObservacao(int id, String nome, DadosTerritorio regiao) {
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
	
	public ArrayList<ArrayList<Double>> getLeituras() {
		return leituras;
	}
	
	public void setSensores(SensorChuva sensorChuva, SensorNivelDoRio sensorRio, SensorUmidade sensorUmidade) {
		this.sensorChuva = sensorChuva;
		this.sensorRio = sensorRio;
		this.sensorUmidade = sensorUmidade;
	}
	
	public void armazenarLeituras() {
		ArrayList<Double> leituras = new ArrayList<>();
		
		double leituraChuva =  getSensorChuva().getLeitura();
		leituras.add(leituraChuva);
		
		double leituraRio = getSensorRio().getLeitura();
		leituras.add(leituraRio);
		
		double leituraUmidade = getSensorUmidade().getLeitura();
		leituras.add(leituraUmidade);
		
		this.leituras.add(leituras);
		
	}


	@Override
	public StatusDeAlerta verificarStatusDeAlerta(double[] limiarAtencao, double[] limiarCritico) {
		
		return null;
	}

}
