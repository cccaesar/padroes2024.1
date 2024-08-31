package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

import br.ifba.inf011.aval2.model.Credencial;
/**Estado concreto*/
public class SomenteLeituraEstado extends AbstractEstado {

    @Override
    public String ler(Credencial credencial, String conteudo) throws IllegalAccessException {
        return conteudo;
    }

    @Override
    public Long getTamanho(String conteudo) throws IllegalAccessException {
        return Long.valueOf(conteudo.length());
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
