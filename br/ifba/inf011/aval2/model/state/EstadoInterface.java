package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

import br.ifba.inf011.aval2.model.Credencial;

public interface EstadoInterface {
    public String escrever(Credencial credencial, String conteudo) throws IllegalAccessException;
    public String ler(Credencial credencial, String conteudo) throws IllegalAccessException;
    public Long getTamanho(String conteudo) throws IllegalAccessException;
    public EstadoInterface excluir() throws OperationNotSupportedException;
    public EstadoInterface liberar() throws OperationNotSupportedException;
    public EstadoInterface bloquear() throws OperationNotSupportedException;
    public EstadoInterface restaurar() throws OperationNotSupportedException;
    public EstadoInterface somenteLeitura() throws OperationNotSupportedException;
}
