package br.ifba.inf011.aval2.model;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import br.ifba.inf011.aval2.model.composite.AbstractEntrada;
import br.ifba.inf011.aval2.model.state.EstadoInterface;
import br.ifba.inf011.aval2.model.state.NormalEstado;
import br.ifba.inf011.aval2.model.strategy.DumpStrategy;

public class Arquivo extends AbstractEntrada implements EntradaOperavel{
	
	private String conteudo;
	private DumpStrategy dumpStrategy;
	private EstadoInterface arquivoEstado;

	public Arquivo(String nome, LocalDate dataCriacao, String conteudo, DumpStrategy dumpStrategy) {
		super(nome, dataCriacao);
		this.conteudo =  conteudo;
		this.dumpStrategy = dumpStrategy;
		this.arquivoEstado = new NormalEstado();
	}

	@Override
	public List<Entrada> getFilhos() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void addFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public Long getTamanho() throws IllegalAccessException{
		return this.arquivoEstado.getTamanho(this);
	}
	
	@Override
	public String ler(Credencial credencial) throws IllegalAccessException{
		return this.arquivoEstado.ler(credencial, this);
	}

	@Override
	public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException {
		this.arquivoEstado.escrever(credencial, conteudo, this);
	}

	@Override
	public String dump(){
		return this.dumpStrategy.dump(conteudo);
	}

	protected void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	protected String getConteudo() {
		return this.conteudo;
	}

	public void excluir() {
		try {
			this.arquivoEstado = this.arquivoEstado.excluir();
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public void restaurar() {
		try {
			this.arquivoEstado = this.arquivoEstado.restaurar();
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public void liberar() {
		try {
			this.arquivoEstado = this.arquivoEstado.liberar();
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public void bloquear() {
		try {
			this.arquivoEstado = this.arquivoEstado.bloquear();
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public void somenteLeitura() {
		try {
			this.arquivoEstado = this.arquivoEstado.somenteLeitura();
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
