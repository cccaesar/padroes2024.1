package br.ifba.inf011.aval2.model.memento;

import java.util.Deque;
import java.util.NoSuchElementException;

public class CuidadorDeArquivos {
    private Deque<ArquivoMemento> snapshots;

    public String restore() throws NoSuchElementException {
        return snapshots.pop().getConteudo();
    }

    public void salvar(ArquivoMemento snapshot) {
        snapshots.addFirst(snapshot);
    }
}
