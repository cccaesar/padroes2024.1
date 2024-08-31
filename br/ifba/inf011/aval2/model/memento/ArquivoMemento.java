package br.ifba.inf011.aval2.model.memento;

/**ArquivoMemento é a classe Memento do padrão memento*/
public class ArquivoMemento {
    private final String conteudo;

    public ArquivoMemento(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }
}
