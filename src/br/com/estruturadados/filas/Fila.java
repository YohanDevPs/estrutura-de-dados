package br.com.estruturadados.filas;

import br.com.estruturadados.listasligadas.ListaDuplamenteLigada;

public class Fila<T> {

    private ListaDuplamenteLigada<T> elementos = new ListaDuplamenteLigada<>();

    public Fila() {
        this.elementos = new ListaDuplamenteLigada<T>();
    }

    public boolean estaVazia() {
        return this.elementos.estaVazia();
    }

    public void enfileirar(T elemento) {
        this.elementos.inserir(elemento);
    }

    public T desfileirar() {
        if(estaVazia()){
            return null;
        }

        T resultado = this.elementos.recuperar(0);
        this.elementos.remover(0);
        return resultado;
    }

    @Override
    public String toString() {
        return "Fila{" + elementos + '}';
    }
}
