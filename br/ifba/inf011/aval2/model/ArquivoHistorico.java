package br.ifba.inf011.aval2.model;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import br.ifba.inf011.aval2.model.memento.ArquivoMemento;
import br.ifba.inf011.aval2.model.memento.CuidadorDeArquivos;
import br.ifba.inf011.aval2.model.strategy.DumpStrategy;

public class ArquivoHistorico extends Arquivo implements EntradaOperavel{

	private CuidadorDeArquivos historico;

	public ArquivoHistorico(String nome, LocalDate dataCriacao, String conteudo, DumpStrategy dumpStrategy) {
		super(nome, dataCriacao, conteudo, dumpStrategy);
	}

	public void checkpoint() {
		try {
			this.historico.salvar(new ArquivoMemento(this, this.ler(null)));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public void restaurar() {
		try {
			this.historico.restaurar();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
}
