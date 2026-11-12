package br.com.citizentech.model;

import java.util.ArrayList;

public abstract class EstrategiaPrevisao {

	private ArrayList<ArrayList<Double>> historico;
	
	public EstrategiaPrevisao(ArrayList<ArrayList<Double>> historico) {
		setHistorico(historico);
	}
	
	public ArrayList<ArrayList<Double>> getHistorico() {
		return historico;
	}
	
	private void setHistorico(ArrayList<ArrayList<Double>> historico) {
		if(historico.isEmpty()) {
			System.out.println("Sensores ainda nao captaram sinais");
			return;
		}
		this.historico = historico;
	}
	
	public abstract double prever();

	
}
