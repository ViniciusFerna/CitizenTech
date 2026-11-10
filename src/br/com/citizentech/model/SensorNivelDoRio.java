package br.com.citizentech.model;

public class SensorNivelDoRio implements Sensor {

	private ComponenteTerritorial areaDoSensor;
	
	private double leitura;
	
	private boolean funcionamento;
	
	public SensorNivelDoRio(ComponenteTerritorial area) {
		this.areaDoSensor = area;
	}
	
	public void setLeitura(double leitura) {
		if(leitura < 0) {
			System.out.println("Falha na leitura");
			return;
		}
		this.leitura = leitura;
	}
	
	public ComponenteTerritorial getAreaDoSensor() {
		return areaDoSensor;
	}


	public double getLeitura() {
		return leitura;
	}


	public boolean isFuncionamento() {
		return funcionamento;
	}


	@Override
	public double lerValor() {
		return leitura;
	}

	@Override
	public boolean verificarFunciomaneto() {
		return funcionamento;
	}

	@Override
	public void ativarSensor() {
		funcionamento = true;
	}

	@Override
	public void desativarSensor() {
		funcionamento = false;
		
	}

}
