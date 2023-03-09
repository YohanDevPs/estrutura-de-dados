package br.com.estruturadados.listasligadas;

public class ListaDuplamenteLigada<T> {

    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaDuplamenteLigada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    public void inserir(T elemento) {
        No<T> novoNo = new No<T>(elemento);
        if(estaVazia()) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            this.ultimoNo.setProximo(novoNo);
            novoNo.setAnterior(this.ultimoNo);
            this.ultimoNo = novoNo;
        }

        this.tamanho++;
    }

    public void inserirEm(int posicao, T elemento) {
        if(posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("Posição inválida [%d]", posicao));
        }

        No<T> novoNo = new No<>(elemento);
        No<T> noAtual = recuperarNo(posicao);

        if(posicao == 0) {
            novoNo.setProximo(this.primeiroNo);
            this.primeiroNo.setAnterior(novoNo);
            this.primeiroNo = novoNo;
        } else if(posicao == tamanho() - 1) {
            this.ultimoNo.setProximo(novoNo);
            novoNo.setAnterior(this.ultimoNo);
            this.ultimoNo = novoNo;
        } else {
            No<T> noAnterior = recuperarNo(posicao - 1);
            noAnterior.setProximo(novoNo);
            novoNo.setAnterior(noAnterior);
            noAtual.setAnterior(novoNo);
            novoNo.setProximo(noAtual);
        }

        this.tamanho++;
    }

    public void inserirPrimeiro(T elemento) {
        inserirEm(0, elemento);
    }

    public void inserirUltimo(T elemento) {
        inserirEm(tamanho() - 1, elemento);
        this.tamanho++;
    }

    public boolean contem(T elemento) {
        No<T> noAtual = this.primeiroNo;

        for (int i = 0; i < tamanho(); i++) {
            if(noAtual.getElemento() == elemento) {
                return true;
            }
            noAtual = noAtual.getProximo();
        }

        return false;
    }

    public int indice(T elemento) {
        No<T> noAtual = this.primeiroNo;

        for (int indice = 0; indice < tamanho(); indice++) {
            if(noAtual.getElemento() == elemento) {
                return indice;
            }
            noAtual = noAtual.getProximo();
        }

        return -1;
    }

    public void remover(int posicao) {
        if(posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("Posição inválida [%d]", posicao));
        }

        if(posicao == 0) {
            No<T> noPosterior = this.primeiroNo.getProximo();
            this.primeiroNo.setProximo(null);
            noPosterior.setAnterior(null);
            this.primeiroNo = noPosterior;
        } else if (posicao == tamanho() - 1) {
            No<T> penultimoNo = this.ultimoNo.getAnterior();
            penultimoNo.setProximo(null);
            this.ultimoNo.setAnterior(null);
            this.ultimoNo = penultimoNo;
        } else {
            No<T> noAtual = recuperarNo(posicao);
            No<T> noAnterior = noAtual.getAnterior();
            No<T> noPosterior = noAtual.getProximo();
            noAnterior.setProximo(noPosterior);
            noPosterior.setAnterior(noAnterior);
            noAtual.setProximo(null);
            noAtual.setAnterior(null);
        }

        this.tamanho--;
    }

    public void remover(T elemento) {
        int indice = indice(elemento);
        if(indice == -1) {
            throw new IllegalArgumentException("Elemento inválido - " + elemento.toString());
        }

        remover(indice);
        this.tamanho--;
    }


    public T recuperar(int posicao) {
        No<T> no = recuperarNo(posicao);
        if(no != null) {
            return no.getElemento();
        }

        return null;
    }

    private No<T> recuperarNo(int posicao) {
        if(posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("Posição inválida [%d]", posicao));
        }

        No<T> resultado = null;
        for (int i = 0; i <= posicao; i++) {
            if (i == 0) {
                resultado = this.primeiroNo;
            } else {
                resultado = resultado.getProximo();
            }
        }

        return resultado;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        if(estaVazia()) {
            return "Lista []";
        }

        No<T> noAtual = this.primeiroNo;
        StringBuilder sb = new StringBuilder();
        sb.append("Lista [");

        int positionAtual = 0;

        while(positionAtual < tamanho()){
            if (noAtual == null) {
                break;
            }
            sb.append(noAtual.getElemento());
            noAtual = noAtual.getProximo();
            positionAtual++;

            if(positionAtual < tamanho()) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
