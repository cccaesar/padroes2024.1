package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.Credencial;

public class SomenteLeituraEstado extends AbstractEstado {

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
