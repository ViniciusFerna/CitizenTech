package br.com.citizentech.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import br.com.citizentech.model.*;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	static DadosTerritorio territorio;
	static EstacaoDeObservacao estacao;
	static SensorChuva sensorChuva;
	static SensorNivelDoRio sensorRio;
	static SensorUmidade sensorUmidade;

	static final String[] NOMES = { "Chuva", "Nivel do rio", "Umidade" };

	public static void main(String[] args) {
		int opcao;
		do {
			exibirMenu();
			System.out.print("Escolha uma opcao: ");
			opcao = Integer.parseInt(scanner.nextLine());
			switch (opcao) {
			case 1 -> criarTerritorio();
			case 2 -> definirLimiares(true);
			case 3 -> definirLimiares(false);
			case 4 -> criarEstacao();
			case 5 -> alternarEstacao();
			case 6 -> configurarSensores();
			case 7 -> alternarSensores();
			case 8 -> gerarLeiturasAleatorias();
			case 9 -> armazenarLeituras();
			case 10 -> mostrarLeituras();
			case 11 -> verificarAlerta();
			case 12 -> fazerPrevisao(true);
			case 13 -> fazerPrevisao(false);
			case 14 -> exibirStatusCompleto();
			case 0 -> System.out.println("Encerrando...");
			default -> System.out.println("Opcao invalida");
			}
		} while (opcao != 0);
	}

	static void exibirMenu() {
		System.out.println("\n===== CITIZENTECH - MONITORAMENTO =====");
		System.out.println("1  - Criar territorio");
		System.out.println("2  - Definir limiares de atencao");
		System.out.println("3  - Definir limiares criticos");
		System.out.println("4  - Criar estacao de observacao");
		System.out.println("5  - Ativar/desativar estacao");
		System.out.println("6  - Configurar sensores");
		System.out.println("7  - Ativar/desativar sensores");
		System.out.println("8  - Gerar leituras aleatorias (0-100)");
		System.out.println("9  - Armazenar leituras na estacao");
		System.out.println("10 - Ver leituras armazenadas");
		System.out.println("11 - Verificar status de alerta");
		System.out.println("12 - Previsao por media movel");
		System.out.println("13 - Previsao por comparacao");
		System.out.println("14 - Exibir status completo");
		System.out.println("0  - Sair");
	}

	// Territorio

	// Cria um territorio no sistema
	static void criarTerritorio() {
		System.out.print("Codigo identificador: ");
		String codigo = scanner.nextLine();
		System.out.print("Populacao: ");
		int populacao = Integer.parseInt(scanner.nextLine());
		territorio = new DadosTerritorio(codigo, populacao);
		System.out.println("Territorio criado.");
	}

	// Define os limiares de atencao e criticos
	static void definirLimiares(boolean atencao) {
		if (territorio == null) {
			System.out.println("Crie um territorio primeiro.");
			return;
		}
		double[] limiares = new double[3];
		System.out.print("Limiar de chuva: ");
		limiares[0] = Double.parseDouble(scanner.nextLine());
		System.out.print("Limiar do nivel do rio: ");
		limiares[1] = Double.parseDouble(scanner.nextLine());
		System.out.print("Limiar de umidade: ");
		limiares[2] = Double.parseDouble(scanner.nextLine());
		if (atencao) {
			territorio.setLimiarAtencao(limiares);
		} else {
			territorio.setLimiarCritico(limiares);
		}
	}

	// Estacao

	// Cria a estacao de observacao no sistema
	static void criarEstacao() {
		if (territorio == null) {
			System.out.println("Crie um territorio primeiro.");
			return;
		}
		System.out.print("Id da estacao: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Nome da estacao: ");
		String nome = scanner.nextLine();
		estacao = new EstacaoDeObservacao(id, nome, territorio);
		System.out.println("Estacao criada.");
	}

	// Ativa ou desativa componente territorial
	static void alternarEstacao() {
		if (!temEstacao())
			return;
		System.out.print("1 - Ativar | 2 - Desativar: ");
		int op = Integer.parseInt(scanner.nextLine());
		if (op == 1) {
			estacao.ativarComponenteTerritorial();
		} else if (op == 2) {
			estacao.desativarComponenteTerritorial();
		} else {
			System.out.println("Opcao invalida");
			return;
		}
		System.out.println("Status da estacao " + estacao.getNome() + ": " + estacao.getStatus());
	}

	// Sensores

	// Cria os sensores
	static void configurarSensores() {
		if (!temEstacao())
			return;
		sensorChuva = new SensorChuva();
		sensorRio = new SensorNivelDoRio();
		sensorUmidade = new SensorUmidade();
		estacao.setSensores(sensorChuva, sensorRio, sensorUmidade);
		System.out.println("Sensores configurados (ainda desativados).");
	}

	// Ativa ou desativa os sensores
	static void alternarSensores() {
		if (!temSensores())
			return;
		System.out.print("1 - Ativar todos | 2 - Desativar todos: ");
		int op = Integer.parseInt(scanner.nextLine());
		if (op == 1) {
			sensorChuva.ativarSensor();
			sensorRio.ativarSensor();
			sensorUmidade.ativarSensor();
		} else if (op == 2) {
			sensorChuva.desativarSensor();
			sensorRio.desativarSensor();
			sensorUmidade.desativarSensor();
		} else {
			System.out.println("Opcao invalida");
			return;
		}
		System.out.println("Sensores atualizados.");
	}

	// Gera as leituras aleatorias dos sensores
	static void gerarLeiturasAleatorias() {
		if (!temSensores())
			return;
		sensorChuva.setLeitura(Math.random() * 100);
		sensorRio.setLeitura(Math.random() * 100);
		sensorUmidade.setLeitura(Math.random() * 100);
		System.out.printf("Leituras geradas -> Chuva: %.2f | Rio: %.2f | Umidade: %.2f%n", sensorChuva.getLeitura(),
				sensorRio.getLeitura(), sensorUmidade.getLeitura());
	}

	// Armazena as leituras para para a previsao
	static void armazenarLeituras() {
		if (!temEstacao())
			return;
		estacao.armazenarLeituras();
		System.out.println("Total de leituras armazenadas: " + estacao.getLeiturasChuva().size());
	}

	// Printa as leituras dos sensores
	static void mostrarLeituras() {
		if (!temEstacao())
			return;
		System.out.println("Chuva:   " + estacao.getLeiturasChuva());
		System.out.println("Rio:     " + estacao.getLeiturasRio());
		System.out.println("Umidade: " + estacao.getLeiturasUmidade());
	}

	// Alerta

	// Calcula a previsao (media movel) de cada sensor, compara com os limiares e explica o resultado
	static void verificarAlerta() {
		if (!temEstacao())
			return;
		if (territorio.getLimiarAtencao() == null || territorio.getLimiarCritico() == null) {
			System.out.println("Defina os limiares de atencao e criticos primeiro.");
			return;
		}
		for (int i = 0; i < 3; i++) {
			ArrayList<Double> historico = historicoDe(i);
			if (historico.isEmpty()) {
				System.out.println(NOMES[i] + ": sem leituras armazenadas.");
				continue;
			}
			// Media movel das ultimas 3 leituras (ou menos, se nao houver 3)
			int janela = Math.min(3, historico.size());
			double previsto = new PrevisaoMediaMovel(historico, janela).prever();
			System.out.println(explicarAlerta(i, previsto));
		}
	}

	// Retorna o historico de leituras do sensor: 0 = chuva, 1 = rio, 2 = umidade
	static ArrayList<Double> historicoDe(int sensor) {
		return switch (sensor) {
		case 0 -> estacao.getLeiturasChuva();
		case 1 -> estacao.getLeiturasRio();
		default -> estacao.getLeiturasUmidade();
		};
	}

	// Monta a explicacao: qual sensor, valor previsto e qual limite foi estourado
	// A umidade e inversa: quanto MENOR o valor, pior a situacao
	static String explicarAlerta(int sensor, double valor) {
		double[] atencao = territorio.getLimiarAtencao();
		double[] critico = territorio.getLimiarCritico();
		boolean inverso = (sensor == 2);
		String lado = inverso ? "abaixo" : "acima";

		boolean passouCritico = inverso ? valor < critico[sensor] : valor > critico[sensor];
		boolean passouAtencao = inverso ? valor < atencao[sensor] : valor > atencao[sensor];

		if (passouCritico) {
			return String.format("CRITICO - %s: valor previsto %.2f esta %s do limiar critico (%.2f)", NOMES[sensor],
					valor, lado, critico[sensor]);
		}
		if (passouAtencao) {
			return String.format("ATENCAO - %s: valor previsto %.2f esta %s do limiar de atencao (%.2f)",
					NOMES[sensor], valor, lado, atencao[sensor]);
		}
		return String.format("NORMAL - %s: valor previsto %.2f dentro dos limites (atencao em %.2f)", NOMES[sensor],
				valor, atencao[sensor]);
	}

	// Previsao

	// Faz os calculos da previsao com as leituras salvas
	static void fazerPrevisao(boolean mediaMovel) {
		if (!temEstacao())
			return;

		System.out.println("1 - Chuva | 2 - Rio | 3 - Umidade");
		System.out.print("Qual leitura prever? ");
		int serie = Integer.parseInt(scanner.nextLine());
		ArrayList<Double> historico;
		switch (serie) {
		case 1 -> historico = estacao.getLeiturasChuva();
		case 2 -> historico = estacao.getLeiturasRio();
		case 3 -> historico = estacao.getLeiturasUmidade();
		default -> {
			System.out.println("Opcao invalida");
			return;
		}
		}

		System.out.print("Quantidade de periodos: ");
		int periodos = Integer.parseInt(scanner.nextLine());
		EstrategiaPrevisao estrategia;
		if (mediaMovel) {
			estrategia = new PrevisaoMediaMovel(historico, periodos);
		} else {
			estrategia = new PrevisaoComparacao(historico, periodos);
		}

		double resultado = estrategia.prever();
		if (Double.isNaN(resultado)) {
			System.out.println("Nao foi possivel calcular a previsao.");
		} else {
			System.out.printf("Previsao: %.2f%n", resultado);
		}
	}

	// Status completo

	// Exibe o resumo de tudo: territorio, limiares, estacao, sensores, leituras e alertas
	static void exibirStatusCompleto() {
		System.out.println("\n===== STATUS COMPLETO =====");

		if (territorio == null) {
			System.out.println("Territorio: nao criado");
		} else {
			System.out.println("Territorio: " + territorio.getCodigoIdentificador() + " | Populacao: "
					+ territorio.getPopulacao());
			double[] atencao = territorio.getLimiarAtencao();
			double[] critico = territorio.getLimiarCritico();
			System.out.println("Limiares de atencao (chuva, rio, umidade): "
					+ (atencao == null ? "nao definidos" : Arrays.toString(atencao)));
			System.out.println("Limiares criticos   (chuva, rio, umidade): "
					+ (critico == null ? "nao definidos" : Arrays.toString(critico)));
		}

		if (estacao == null) {
			System.out.println("Estacao: nao criada");
			return;
		}
		System.out.println("Estacao: " + estacao.getId() + " - " + estacao.getNome() + " | Status: "
				+ (estacao.getStatus() == null ? "nunca ativada" : estacao.getStatus()));

		if (sensorChuva == null) {
			System.out.println("Sensores: nao configurados");
		} else {
			System.out.printf("Sensor de chuva:  %s | ultima leitura: %.2f%n",
					sensorChuva.isFuncionamento() ? "ATIVO" : "DESATIVADO", sensorChuva.getLeitura());
			System.out.printf("Sensor do rio:    %s | ultima leitura: %.2f%n",
					sensorRio.isFuncionamento() ? "ATIVO" : "DESATIVADO", sensorRio.getLeitura());
			System.out.printf("Sensor de umidade: %s | ultima leitura: %.2f%n",
					sensorUmidade.isFuncionamento() ? "ATIVO" : "DESATIVADO", sensorUmidade.getLeitura());
		}

		System.out.println("Leituras armazenadas: " + estacao.getLeiturasChuva().size());
		System.out.println("Alertas:");
		verificarAlerta();
	}

	// Verifica se ja tem uma estacao criada no sistema
	static boolean temEstacao() {
		if (estacao == null) {
			System.out.println("Crie uma estacao primeiro.");
			return false;
		}
		return true;
	}

	// Verifica se os sensores ja foram criados no sistema
	static boolean temSensores() {
		if (!temEstacao())
			return false;
		if (sensorChuva == null) {
			System.out.println("Configure os sensores primeiro.");
			return false;
		}
		return true;
	}
}