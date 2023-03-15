package br.com.estruturadados.main.arvorebinaria;

import br.com.estruturadados.main.modelos.Pessoa;

public class NoArvorePessoa extends NoArvore<Pessoa> {

    public NoArvorePessoa(Pessoa valor) {
        super(valor);
    }

    @Override
    public int peso() {
        return this.valor.getId();
    }
}
