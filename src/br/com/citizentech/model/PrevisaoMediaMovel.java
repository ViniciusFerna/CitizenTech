package br.com.citizentech.model;

import java.util.ArrayList;

public class PrevisaoMediaMovel extends EstrategiaPrevisao{
	
	private int periodosPrevisao;

	public PrevisaoMediaMovel(ArrayList<ArrayList<Double>> historico, int periodosPrevisao) {
		super(historico);		
		setPeriodosPrevisao(periodosPrevisao, historico);
	}

	public int getPeriodosPrevisao() {
		return periodosPrevisao;
	}

	private void setPeriodosPrevisao(int periodosPrevisao, ArrayList<ArrayList<Double>> historico) {
		if(periodosPrevisao < 0) {
			System.out.println("Quantidade de periodos invalida");
			return;
		}
		
		if(periodosPrevisao > historico.size()) {
			System.out.println("O historico nao tem o tamanho necessario para a quantidade de periodos que quer prever");
			return;
		}
		this.periodosPrevisao = periodosPrevisao;
	}

	@Override
	public double prever() {
		ArrayList<ArrayList<Double>> leituras = getHistorico();
		
		
		
		return 0;
	}

	
	
}
