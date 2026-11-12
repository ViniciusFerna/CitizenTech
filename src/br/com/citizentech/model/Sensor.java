package br.com.citizentech.model;

public interface Sensor {

	public double lerValor();
	
	public boolean verificarFuncionamento();
	
	public void ativarSensor();
	
	public void desativarSensor();
	
}
