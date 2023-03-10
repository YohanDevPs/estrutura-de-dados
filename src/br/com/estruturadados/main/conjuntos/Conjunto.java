package br.com.estruturadados.main.conjuntos;

import br.com.estruturadados.main.listasligadas.ListaLigada;

public class Conjunto<T> {

    private ListaLigada<T> elementos;

    public Conjunto() {
        this.elementos = new ListaLigada<T>();
    }

    public boolean inserir(T elemento) {
        if(elemento != null && !contemOtimizado(elemento)) {
          this.elementos.inserir(elemento);
          return true;
        }
        return false;
    }

    public boolean inserirEm(int posicao,T elemento) {
        if(elemento != null && !contemOtimizado(elemento)) {
            this.elementos.inserirEm(posicao, elemento);
            return true;
        }
        return false;
    }

    public T recuperar(int posicao) {
        return this.elementos.recuperar(posicao);
    }

    public boolean estaVazio() {
        return this.elementos.estaVazia();
    }

    public int tamanho() {
        return this.elementos.tamanho();
    }

    public int indice(T elemento) {
      return this.elementos.indice(elemento);
    }

    public boolean contem(T elemento) {
        return this.elementos.contem(elemento);
    }

    public void remover(T elemento) {
        this.elementos.remover(elemento);
    }

    public void remover(int posicao) {
        this.elementos.remover(posicao);
    }

    private boolean contemOtimizado(T elemento) {
        for(int i = 0; i < this.elementos.tamanho(); i++) {
            T elem = this.elementos.recuperar(i);
            if(elem.hashCode() == elemento.hashCode()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conjunto{" + elementos + "}";
    }
}
