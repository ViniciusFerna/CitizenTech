package br.com.citizentech.model;

import java.util.ArrayList;

public abstract class EstrategiaPrevisao {

    private ArrayList<Double> historico;

    public EstrategiaPrevisao(ArrayList<Double> historico) { 
        setHistorico(historico);
    }

    public ArrayList<Double> getHistorico() {

        if (historico == null) {
            return new ArrayList<>();
        }

        return historico;
    }

    private void setHistorico(ArrayList<Double> historico) {

        if (historico == null || historico.isEmpty()) {
            System.out.println("Erro: Historico vazio ou invalido");
            return;
        }

        for (Double leitura : historico) {
            if (leitura == null ||
                leitura < 0) {

                System.out.println("Erro: Historico possui leituras invalidas");
                return;
            }
        }

        this.historico = historico;
    }

    public abstract double prever();
    
    
}


