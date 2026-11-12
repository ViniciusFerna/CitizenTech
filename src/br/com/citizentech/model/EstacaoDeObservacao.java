package br.com.citizentech.model;

import java.util.ArrayList;

public class EstacaoDeObservacao extends ComponenteTerritorial {

    private SensorChuva sensorChuva;
    private SensorNivelDoRio sensorRio;
    private SensorUmidade sensorUmidade;

    private ArrayList<Double> leiturasChuva = new ArrayList<>();
    private ArrayList<Double> leiturasRio = new ArrayList<>();
    private ArrayList<Double> leiturasUmidade = new ArrayList<>();

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

    public ArrayList<Double> getLeiturasChuva() {
        return leiturasChuva;
    }

    public ArrayList<Double> getLeiturasRio() {
        return leiturasRio;
    }

    public ArrayList<Double> getLeiturasUmidade() {
        return leiturasUmidade;
    }

    public void setSensores(
            SensorChuva sensorChuva,
            SensorNivelDoRio sensorRio,
            SensorUmidade sensorUmidade) {

        if (sensorChuva == null ||
            sensorRio == null ||
            sensorUmidade == null) {

            System.out.println("Erro: Sensores invalidos");
            return;
        }

        this.sensorChuva = sensorChuva;
        this.sensorRio = sensorRio;
        this.sensorUmidade = sensorUmidade;
    }

    public void armazenarLeituras() {

        if (sensorChuva == null ||
            sensorRio == null ||
            sensorUmidade == null) {

            System.out.println("Erro: Sensores nao configurados");
            return;
        }

        if (!sensorChuva.verificarFuncionamento() ||
            !sensorRio.verificarFuncionamento() ||
            !sensorUmidade.verificarFuncionamento()) {

            System.out.println("Erro: Existem sensores desativados");
            return;
        }

        double chuva = sensorChuva.lerValor();
        double rio = sensorRio.lerValor();
        double umidade = sensorUmidade.lerValor();

        if (chuva < 0 ||
            rio < 0 ||
            umidade < 0 ||
            chuva > 100 ||
            umidade > 100) {

            System.out.println("Erro: Leituras invalidas");
            return;
        }

        leiturasChuva.add(chuva);
        leiturasRio.add(rio);
        leiturasUmidade.add(umidade);
    }

    @Override
    public StatusDeAlerta verificarStatusDeAlerta(double[] limiarAtencao, double[] limiarCritico) {
    	
    	double valorChuva = sensorChuva.getLeitura();
    	double valorRio = sensorRio.getLeitura();
    	double valorUmidade = sensorUmidade.getLeitura();
    	
		if(valorChuva > limiarCritico[0] || 
		   valorRio > limiarCritico[1] ||
	       valorUmidade < limiarCritico[2]) {
	    	return StatusDeAlerta.CRITICO;
	    }
    		
    	if(valorChuva > limiarAtencao[0] && valorChuva < limiarCritico[0] ||
    	   valorRio > limiarAtencao[1] && valorRio < limiarCritico[1] ||
    	   valorUmidade < limiarAtencao[2] && valorUmidade > limiarCritico[2]) {
    		return StatusDeAlerta.ATENCAO;
    	}
    		
        return StatusDeAlerta.NORMAL;
    }
    
}

