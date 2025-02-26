package br.ifba.inf011.aval2.model.memento;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/**CuidadorDeArquivos é a classe cuidadora do padrão memento*/
public class CuidadorDeArquivos {
    private Deque<ArquivoMemento> snapshots;

    public CuidadorDeArquivos() {
        this.snapshots = new LinkedList<ArquivoMemento>();
    }

    public String restore() throws NoSuchElementException {
        return snapshots.pop().getConteudo();
    }

    public void salvar(ArquivoMemento snapshot) {
        snapshots.addFirst(snapshot);
    }
}
