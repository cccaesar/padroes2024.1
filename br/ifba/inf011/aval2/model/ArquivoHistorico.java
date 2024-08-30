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
		this.historico.salvar(new ArquivoMemento(this.getConteudo()));
	}

	public void restore() {
		try {
			String conteudoAnterior = this.historico.restore();
			this.setConteudo(conteudoAnterior);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
}
