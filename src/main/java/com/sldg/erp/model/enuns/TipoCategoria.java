package com.sldg.erp.model.enuns;

public enum TipoCategoria {

	KG("Kilo"), 
	PACOTE("Pacote");
	
	private String descricao;
	
	TipoCategoria(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
