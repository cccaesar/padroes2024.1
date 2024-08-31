package br.ifba.inf011.aval2;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.ArquivoHistorico;
import br.ifba.inf011.aval2.model.Credencial;
import br.ifba.inf011.aval2.model.Entrada;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.Pasta;
import br.ifba.inf011.aval2.model.proxy.LogOperacaoProxy;
import br.ifba.inf011.aval2.model.strategy.BinarioStrategy;
import br.ifba.inf011.aval2.model.strategy.TextoStrategy;

public class App {
	
	
	public void runQ1() throws IllegalAccessException  {
		
		Credencial user01 = new Credencial("user01");
		
		EntradaOperavel a1 = new Arquivo("A1", LocalDate.now(), "00011000100011100000011111110101", new TextoStrategy());
		EntradaOperavel b1 = new Arquivo("B1", LocalDate.now(), "UM ARQUIVO TAMANHO GRANDE", new BinarioStrategy());
		EntradaOperavel c1 = new Arquivo("C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE", new TextoStrategy());
		
		Entrada a = new Pasta("A", LocalDate.now());
		Entrada b = new Pasta("B", LocalDate.now());
		Entrada c = new Pasta("C", LocalDate.now());
		Entrada raiz = new Pasta("/", LocalDate.now());
		
		raiz.addFilho(a);
		raiz.addFilho(b);
		
		a.addFilho(a1);
		
		b.addFilho(c);
		b.addFilho(b1);
		
		c.addFilho(c1);

		try {
			b1.escrever(user01, "CINCO");
		}catch(IllegalAccessException ex) {
			System.out.println("NÃO FOI POSSIVEL ESCREVER EM A1");
		}
			
		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");

		try {
			b1.escrever(user01, "CINCO+2");
		}catch(IllegalAccessException ex) {
			System.out.println("NÃO FOI POSSIVEL ESCREVER EM A1");
		}
		
		try {
			System.out.println("B1: " + b1.ler(user01));
		} catch (IllegalAccessException e) {
			System.out.println("NÃO FOI POSSIVEL LER DE A1");
		}			
		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");
	}
	
	public void runQ2() throws IllegalAccessException {
		Credencial user01 = new Credencial("user01");
		
		EntradaOperavel a1 = new Arquivo("A1", LocalDate.now(), "00011000100011100000011111110101", new TextoStrategy());
		EntradaOperavel a2 = new Arquivo("A2", LocalDate.now(), "O Rio de Janeiro continua lindo", new BinarioStrategy());
		LogOperacaoProxy proxy = new LogOperacaoProxy(new Arquivo ("A3", LocalDate.now(), "Testando o proxy", new BinarioStrategy()));
		ArquivoHistorico ah1 = new ArquivoHistorico("AH1", LocalDate.now(), "Blá blá blá", new BinarioStrategy());
		try {
			System.out.println(a1.getNome());
			System.out.println("Dump\t" + a1.dump(user01));
			System.out.println("Leitura\t" + a1.ler(user01));
			System.out.println("-------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println(a2.getNome());
			System.out.println("Dump\t" + a2.dump(user01));
			System.out.println("Leitura\t" + a2.ler(user01));
			System.out.println("-------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			a2.bloquear();
			System.out.println("Tamanho de a2:" + a2.getTamanho().toString());
			a2.liberar();
			a2.escrever(user01, "O Rio de Janeiro continua sendo");
			System.out.println(a2.ler(user01));
			System.out.println("Excluindo a2...");
			a2.excluir();
			System.out.println("Tamanho de a2 após sua exclusão:" + a2.getTamanho().toString());
			a2.restaurar();
			System.out.println("Conteudo de a2 após ser restaurado da lixeira:" + a2.ler(user01));
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
		try {
			proxy.somenteLeitura();
			System.out.println(proxy.ler(user01));
			proxy.ler(user01);
			proxy.liberar();
			proxy.escrever(user01, "Escrevendo no arquivo através do proxy");
			System.out.println(proxy.doLog());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ah1.checkpoint();
			System.out.println("Conteudo de 'AH1' antes de ser sobrescrito: " + ah1.ler(user01));
			ah1.escrever(user01, "Aaaaaah!");
			System.out.println("Conteudo de 'AH1' após ser sobrescrito: " + ah1.ler(user01));
			ah1.restore();
			System.out.println("Conteudo de 'AH1' após seu conteudo ser restaurado: " + ah1.ler(user01));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IllegalAccessException {
		App app = new App();
		app.runQ2();
	}

}
