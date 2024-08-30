package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

public class ExcluidoEstado extends AbstractEstado {

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
        throw new OperationNotSupportedException();
    }

    @Override
    public EstadoInterface restaurar() throws OperationNotSupportedException {
        return new NormalEstado();
    }

    @Override
    public EstadoInterface somenteLeitura() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

}
