package br.com.estruturadados.main.conjuntos;

import br.com.estruturadados.main.espalhamento.TabelaEspalhamento;

public class Conjunto<T> {

    private TabelaEspalhamento<T> elementos;

    public Conjunto() {
        this.elementos = new TabelaEspalhamento<T>();
    }

    public boolean inserir(T elemento) {
         return this.elementos.inserir(elemento);
    }

    public boolean estaVazio() {
        return this.elementos.tamanho() == 0;
    }

    public int tamanho() {
        return this.elementos.tamanho();
    }

    public boolean contem(T elemento) {
        return this.elementos.contem(elemento);
    }

    public void remover(T elemento) {
        this.elementos.remover(elemento);
    }

    @Override
    public String toString() {
        return "Conjunto{" + elementos + "}";
    }
}
