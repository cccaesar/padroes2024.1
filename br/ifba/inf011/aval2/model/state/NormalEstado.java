package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.Credencial;

public class NormalEstado extends AbstractEstado{

    @Override
    public void escrever(Credencial credencial, String conteudo, Arquivo contexto) throws IllegalAccessException {
        contexto.escrever(credencial, conteudo);
    }

    @Override
    public String ler(Credencial credencial, Arquivo contexto) throws IllegalAccessException {
        return contexto.ler(credencial);
    }

    @Override
    public Long getTamanho(Arquivo contexto) throws IllegalAccessException {
        return contexto.getTamanho();
    }

    @Override
    public EstadoInterface bloquear() throws OperationNotSupportedException {
        return new BloqueadoEstado();
    }

    @Override
    public EstadoInterface excluir() throws OperationNotSupportedException {
        return new ExcluidoEstado();
    }

    @Override
    public EstadoInterface liberar() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public EstadoInterface restaurar() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public EstadoInterface somenteLeitura() throws OperationNotSupportedException {
        return new SomenteLeituraEstado();
    }


}
