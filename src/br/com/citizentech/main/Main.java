package br.com.citizentech.main;

import br.com.citizentech.model.DadosTerritorio;

public class Main {

	public static void main(String[] args) {
		
		DadosTerritorio t = new DadosTerritorio("Cotia", 12000, false);
		
		double[] limiarAtencao = {1, 2, 3};
		
		double[] limiarCritico = {2, 3, 4};
		
		t.setLimiarAtencao(limiarAtencao);
		
		t.setLimiarCritico(limiarCritico);
		
		System.out.println(t.getLimiarAtencao()[0]);
		
		System.out.println(t.getLimiarCritico()[0]);
		
		double[] limiarAtencaoNovo = {5, 6, 7, 8};
		
		double[] limiarAtencaoCritico = {7, 8, 9, 190};
		
		t.setLimiarAtencao(limiarAtencaoNovo);
		
		t.setLimiarCritico(limiarAtencaoCritico);
		
		System.out.println(t.getLimiarAtencao()[0]);
		
		System.out.println(t.getLimiarCritico()[0]);
		
	}
	
}
