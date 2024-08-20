package br.ifba.inf011.aval2.model;

import java.time.LocalDate;

import br.ifba.inf011.aval2.model.strategy.DumpStrategy;

public class ArquivoHistorico extends Arquivo implements EntradaOperavel{


	public ArquivoHistorico(String nome, LocalDate dataCriacao, String conteudo, DumpStrategy dumpStrategy) {
		super(nome, dataCriacao, conteudo, dumpStrategy);
	}


}
