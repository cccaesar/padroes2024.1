package br.ifba.inf011.aval2.model.strategy;

import br.ifba.inf011.aval2.model.Conversor2Bin;
/**BinarioStrategy é uma estratégia concreta*/
public class BinarioStrategy implements DumpStrategy {
    
    private Conversor2Bin conversor2Bin;
    
    public BinarioStrategy () {
        this.conversor2Bin = new Conversor2Bin();
    }

    @Override
    public String dump(String conteudo) {
        return this.conversor2Bin.toBinary(conteudo);
    }
    
}
