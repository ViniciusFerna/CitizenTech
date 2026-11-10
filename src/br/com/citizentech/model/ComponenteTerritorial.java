package br.com.citizentech.model;

public abstract class ComponenteTerritorial {
	
	private int id;
	
	private String nome;
	
	private String regiao;
	
	private StatusDeAtivacao statusDeAtivacao;
	
	public ComponenteTerritorial(int id, String nome, String regiao) {
		this.id = id;
		this.nome = nome;
		this.regiao = regiao;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public StatusDeAtivacao getStatus() {
		return statusDeAtivacao;
	}
	
	public void ativarComponenteTerritorial() {
		this.statusDeAtivacao = StatusDeAtivacao.ATIVO;
	}
	
	public void desativarComponenteTerritorial() {
		this.statusDeAtivacao = StatusDeAtivacao.DESATIVADO;
	}
	
	public abstract StatusDeAlerta verificarStatusDeAlerta();

}
