package br.ifba.inf011.aval2.model.memento;

import br.ifba.inf011.aval2.model.ArquivoHistorico;

public class ArquivoMemento {
    private ArquivoHistorico arquivoHistorico;
    private String conteudo;

    public ArquivoMemento(ArquivoHistorico arquivoHistorico, String conteudo) {
        this.arquivoHistorico = arquivoHistorico;
        this.conteudo = conteudo;
    }

    public void restore() {
        try {
            this.arquivoHistorico.escrever(null, this.conteudo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
