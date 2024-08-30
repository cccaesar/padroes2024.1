package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.Credencial;

public abstract class AbstractEstado implements EstadoInterface {

    @Override
    public String escrever(Credencial credencial, String conteudo) throws IllegalAccessException {
        throw new IllegalAccessException("O estado atual do arquivo não permite escrita");
        
    }

    @Override
    public String ler(Credencial credencial, String conteudo) throws IllegalAccessException {
        throw new IllegalAccessException("O estado atual do arquivo não permite leitura");
    }

    public Long getTamanho(String conteudo) throws IllegalAccessException {
        return 0L;
    }

    public EstadoInterface excluir() throws OperationNotSupportedException {
        return this;
    }
    public EstadoInterface liberar() throws OperationNotSupportedException {
        return this;
    }
    public EstadoInterface bloquear() throws OperationNotSupportedException {
        return this;
    }
    public EstadoInterface restaurar() throws OperationNotSupportedException  {
        return this;
    }
    public EstadoInterface somenteLeitura() throws OperationNotSupportedException {
        return this;
    }
}
