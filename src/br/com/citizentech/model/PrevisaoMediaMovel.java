package br.com.citizentech.model;

import java.util.ArrayList;

public class PrevisaoMediaMovel extends EstrategiaPrevisao {

    private int periodosPrevisao;

    public PrevisaoMediaMovel(ArrayList<Double> historico, int periodosPrevisao) {
        super(historico);
        setPeriodosPrevisao(periodosPrevisao);
    }

    public int getPeriodosPrevisao() {
        return periodosPrevisao;
    }

    private void setPeriodosPrevisao(int periodosPrevisao) {

        if (periodosPrevisao <= 0) {
            System.out.println("Erro: Quantidade de periodos invalida");
            return;
        }

        if (periodosPrevisao > getHistorico().size()) {
            System.out.println("Erro: Historico insuficiente");
            return;
        }

        this.periodosPrevisao = periodosPrevisao;
    }

    @Override
    public double prever() {

        ArrayList<Double> leituras = getHistorico();

        if (leituras.size() < periodosPrevisao) {
            System.out.println("Erro: Nao foi possivel calcular a media movel");
            return Double.NaN;
        }

        double soma = 0;

        int inicio = leituras.size() - periodosPrevisao;

        for (int i = inicio; i < leituras.size(); i++) {
            soma += leituras.get(i);
        }

        return soma / periodosPrevisao;
    }
    
}



