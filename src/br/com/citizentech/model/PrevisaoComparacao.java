package br.com.citizentech.model;

import java.util.ArrayList;

public class PrevisaoComparacao extends EstrategiaPrevisao {

    private int periodosComparacao;

    public PrevisaoComparacao(ArrayList<Double> historico, int periodosComparacao) {
        super(historico);
        setPeriodosComparacao(periodosComparacao);
    }

    public int getPeriodosComparacao() {
        return periodosComparacao;
    }

    private void setPeriodosComparacao(int periodosComparacao) {

        if (periodosComparacao <= 0) {
            System.out.println("Erro: Quantidade de periodos invalida");
            return;
        }

        if (getHistorico().size() < periodosComparacao * 2L) {
            System.out.println("Erro: Historico insuficiente para comparar dois periodos");
            return;
        }

        this.periodosComparacao = periodosComparacao;
    }

    @Override
    public double prever() {

        ArrayList<Double> leituras = getHistorico();

        if (periodosComparacao <= 0 ||
            leituras.size() < periodosComparacao * 2L) {

            System.out.println(
                "Erro: Nao foi possivel calcular a previsao por comparacao"
            );
            return Double.NaN;
        }

        int quantidade = leituras.size();

        int inicioAnterior = quantidade - (periodosComparacao * 2);
        int inicioAtual = quantidade - periodosComparacao;

        double somaAnterior = 0;
        double somaAtual = 0;

        for (int i = inicioAnterior; i < inicioAtual; i++) {

            somaAnterior += leituras.get(i);
        }

        for (int i = inicioAtual; i < quantidade; i++) {

            somaAtual += leituras.get(i);
        }

        double mediaAnterior = somaAnterior / periodosComparacao;
        double mediaAtual = somaAtual / periodosComparacao;

        double variacao = mediaAtual - mediaAnterior;

        double previsao = mediaAtual + variacao;

        return Math.max(0, previsao);
        
        
    }
    
}
