package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

import br.ifba.inf011.aval2.model.Arquivo;

public class BloqueadoEstado extends AbstractEstado {

    @Override
    public Long getTamanho(Arquivo contexto) throws IllegalAccessException {
        return contexto.getTamanho();
    }

    @Override
    public EstadoInterface bloquear() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public EstadoInterface excluir() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public EstadoInterface liberar() throws OperationNotSupportedException {
        return new NormalEstado();
    }

    @Override
    public EstadoInterface restaurar() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public EstadoInterface somenteLeitura() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    
}
