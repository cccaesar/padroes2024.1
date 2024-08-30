package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.Credencial;

public interface EstadoInterface {
    public void escrever(Credencial credencial, String conteudo, Arquivo contexto) throws IllegalAccessException;
    public String ler(Credencial credencial, Arquivo contexto) throws IllegalAccessException;
    public Long getTamanho(Arquivo contexto) throws IllegalAccessException;
    public EstadoInterface excluir() throws OperationNotSupportedException;
    public EstadoInterface liberar() throws OperationNotSupportedException;
    public EstadoInterface bloquear() throws OperationNotSupportedException;
    public EstadoInterface restaurar() throws OperationNotSupportedException;
    public EstadoInterface somenteLeitura() throws OperationNotSupportedException;
}
