package br.com.citizentech.model;

import java.util.Scanner;

public class DadosTerritorio {
	
	private String codigoIdentificador;
	
	private String codigoAcesso;
	
	private int populacao;
	
	private double[] limiarAtencao; // SensorChuva, SensorNivelDoRio, SensorUmidade
	
	private double[] limiarCritico; // SensorChuva, SensorNivelDoRio, SensorUmidade

	public DadosTerritorio(
			String codigoIdentificador,
			int populacao) {
		
		setCodigoIdentificador(codigoIdentificador);
		setPopulacao(populacao);
		setCodigoAcesso();
		
	}

	public String getCodigoIdentificador() {
		return codigoIdentificador;
	}

	private void setCodigoIdentificador(String codigoIdentificador) {
		if(codigoIdentificador.isBlank()) {
			System.out.println("Erro ao criar territorio: Digite codigo identificador valido");
			return;
		}
		this.codigoIdentificador = codigoIdentificador;
	}
	
	public int getPopulacao() {
		return populacao;
	}
	
	public void setPopulacao(int populacao) {
		if(populacao < 0) {
			System.out.println("Erro ao criar territorio: Populacao deve ser um valor valido");
			return;
		}
		this.populacao = populacao;
	}

	public double[] getLimiarAtencao() {
		return limiarAtencao;
	}

	public void setLimiarAtencao(double[] limiarAtencao) {
		int quantidadeLeituras = limiarAtencao.length;
			
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o codigo de acesso para alterar os limiares de atencao: ");
		
		String codigoDigitado = scanner.nextLine();
		
		if(!codigoDigitado.equals(getCodigoAcesso())) {
			System.out.println("Erro ao adicionar limiares de atencao: Codigo de acesso incorreto");
			return;
		}
		
		for(int i = 0; i < quantidadeLeituras; i++) {
			if(limiarAtencao[i] < 0 || limiarAtencao[i] > 100) {
				System.out.println("Os valores dos limiares devem estar entre 0 e 100");
				return;
			}
		}
		
		if(quantidadeLeituras != 3) {
			System.out.println("Erro ao adicionar limiares criticos: Digite tres limiares de atencao");
			return;
		}
		
		this.limiarAtencao = limiarAtencao;
	}

	public double[] getLimiarCritico() {
		return limiarCritico;
	}

	public void setLimiarCritico(double[] limiarCritico) {
		int quantidadeLeituras = limiarCritico.length;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o codigo de acesso para alterar os limiares criticos: ");
		
		String codigoDigitado = scanner.nextLine();
		
		if(!codigoDigitado.equals(getCodigoAcesso())) {
			System.out.println("Erro ao adicionar limiares criticos: Codigo de acesso incorreto");
			return;
		}
		
		for(int i = 0; i < quantidadeLeituras; i++) {
			if(limiarAtencao[i] < 0 || limiarAtencao[i] > 100) {
				System.out.println("Os valores dos limiares devem estar entre 0 e 100");
				return;
			}
		}
		
		if(quantidadeLeituras != 3) {
			System.out.println("Erro ao adicionar limiares criticos: Digite tres limiares criticos");
			return;
		}
		
		this.limiarCritico = limiarCritico;
	}
	
	private String getCodigoAcesso() {
		return codigoAcesso;
	}

	private void setCodigoAcesso() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o codigo de acesso que deseja associar a esse territorio(".concat(getCodigoIdentificador()) + "): ");
		
		String codigoAcesso = scanner.nextLine();
		
		if(codigoAcesso.isBlank()) {
			System.out.println("Erro ao criar territorio: Digite codigo de acesso valido");
			return;
		}
		this.codigoAcesso = codigoAcesso;
	}

	

	
	
}
