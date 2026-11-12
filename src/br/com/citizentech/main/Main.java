package br.com.citizentech.main;

import br.com.citizentech.model.DadosTerritorio;
import br.com.citizentech.model.EstacaoDeObservacao;
import br.com.citizentech.model.SensorChuva;
import br.com.citizentech.model.SensorNivelDoRio;
import br.com.citizentech.model.SensorUmidade;

public class Main {

	public static void main(String[] args) {
		
		
		 DadosTerritorio t = new DadosTerritorio("Cotia", 12000, false);
		 /*
		 * double[] limiarAtencao = {1, 2, 3};
		 * 
		 * double[] limiarCritico = {2, 3, 4};
		 * 
		 * t.setLimiarAtencao(limiarAtencao);
		 * 
		 * t.setLimiarCritico(limiarCritico);
		 * 
		 * System.out.println(t.getLimiarAtencao()[0]);
		 * 
		 * System.out.println(t.getLimiarCritico()[0]);
		 * 
		 * double[] limiarAtencaoNovo = {5, 6, 7};
		 * 
		 * double[] limiarAtencaoCritico = {7, 8, 9};
		 * 
		 * t.setLimiarAtencao(limiarAtencaoNovo);
		 * 
		 * t.setLimiarCritico(limiarAtencaoCritico);
		 * 
		 * System.out.println(t.getLimiarAtencao()[0]);
		 * 
		 * System.out.println(t.getLimiarCritico()[0]);
		 */
		
		SensorChuva s1 = new SensorChuva();
		SensorNivelDoRio s2 = new SensorNivelDoRio();
		SensorUmidade s3 = new SensorUmidade();
		
		EstacaoDeObservacao estacao1 = new EstacaoDeObservacao(1, "Corrego", t);
		
		estacao1.setSensores(s1, s2, s3);
		
		s1.setLeitura(100);
		s2.setLeitura(40);
		s3.setLeitura(20);
		
		estacao1.armazenarLeituras();
		
		s1.setLeitura(80);
		s2.setLeitura(100);
		s3.setLeitura(40);
		
		estacao1.armazenarLeituras();
		
		
	
		
	}
	
}
