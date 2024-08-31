package br.ifba.inf011.aval2.model;

import javax.naming.OperationNotSupportedException;

public interface Operavel {
	
	public String dump(Credencial credencial);
	public String ler(Credencial credencial) throws IllegalAccessException;
	public void escrever(Credencial credencial, String escrever) throws IllegalAccessException;
	public void excluir() throws OperationNotSupportedException;
    public void liberar() throws OperationNotSupportedException;
    public void bloquear() throws OperationNotSupportedException;
    public void restaurar() throws OperationNotSupportedException;
    public void somenteLeitura() throws OperationNotSupportedException;
}
