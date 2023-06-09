package br.com.estruturadados.main;

import java.util.*;

import br.com.estruturadados.main.arvorebinaria.Arvore;
import br.com.estruturadados.main.arvorebinaria.NoArvore;
import br.com.estruturadados.main.arvorebinaria.NoArvorePessoa;
import br.com.estruturadados.main.conjuntos.Conjunto;
import br.com.estruturadados.main.filas.Fila;
import br.com.estruturadados.main.listasligadas.ListaDuplamenteLigada;
import br.com.estruturadados.main.listasligadas.ListaLigada;
import br.com.estruturadados.main.mapas.Mapa;
import br.com.estruturadados.main.modelos.Pessoa;
import br.com.estruturadados.main.pilhas.Pilha;
import br.com.estruturadados.main.vetores.Vetor;
import com.sun.source.tree.Tree;

public class Main {

	public static void main(String[] args) {
		System.out.println("Digite a opção desejada: ");

		System.out.println("1. Gerenciamento de memória");
		System.out.println("2. Vetores");
		System.out.println("3. Lista Ligada");
		System.out.println("4. Lista Duplamente Ligada");
		System.out.println("5. Pilha");
		System.out.println("6. Fila");
		System.out.println("7. Conjunto");
		System.out.println("8. Mapa");
		System.out.println("9. Arvore Binária");

		Scanner scanner = new Scanner(System.in);
		int opcao = scanner.nextInt();
		
		switch (opcao) {
			case 1: {
				fazerGerenciamentoMemoria();
				break;
			}
			case 2: {
				fazerVetor();
				break;
			}
			case 3: {
				fazerListaLigada();
				break;
			}
			case 4: {
				fazerListaDuplamenteLigada();
				break;
			}
			case 5: {
				fazerPilha();
				break;
			}
			case 6: {
				fazerFila();
				break;
			}
			case 7: {
				fazerConjunto();
				break;
			}
			case 8: {
				fazerMapa();
				break;
			}
			case 9: {
				fazerArvoreBinaria();
				break;
			}
		}
		scanner.close();
}

	private static void fazerArvoreBinaria() {
		Arvore<Pessoa> arvorePessoas = new Arvore<Pessoa>();
		System.out.println(arvorePessoas);

		arvorePessoas.inserir(new NoArvorePessoa(new Pessoa(5, "Yohan")));
		System.out.println(arvorePessoas);
		arvorePessoas.inserir(new NoArvorePessoa(new Pessoa(4, "Camila")));
		System.out.println(arvorePessoas);
		arvorePessoas.inserir(new NoArvorePessoa(new Pessoa(6, "Matheus")));
		arvorePessoas.inserir(new NoArvorePessoa(new Pessoa(1, "Jessica")));
		arvorePessoas.inserir(new NoArvorePessoa(new Pessoa(8, "Carlos")));
		System.out.println(arvorePessoas);

		System.out.println("Busca...");
		NoArvore<Pessoa> noPessoa4 = new NoArvorePessoa(new Pessoa(4, "Camila"));
		System.out.println(arvorePessoas.buscar(noPessoa4));

		System.out.println("****************");
		System.out.println("*** EM ORDEM ***");
		arvorePessoas.emOrdem();
		System.out.println("*****************");
		System.out.println("*** PRE ORDEM ***");
		arvorePessoas.preOrdem();
		System.out.println("*****************");
		System.out.println("*** POS ORDEM ***");
		arvorePessoas.posOrdem();
		System.out.println("*****************");
		System.out.println("*** ALTURA ***");
		System.out.println(arvorePessoas.altura());
	}


	private static void fazerMapa() {
		Mapa<String, Pessoa> mapaPessoas = new Mapa<>();
		System.out.println(mapaPessoas);
		mapaPessoas.adicionar("legal", new Pessoa(1, "Yohan"));
		System.out.println(mapaPessoas.contemChave("legal"));
		System.out.println(mapaPessoas.contemChave("chata"));
		mapaPessoas.adicionar("chata", new Pessoa(2, "Camila"));
		System.out.println(mapaPessoas.contemChave("chata"));
		System.out.println(mapaPessoas);
		mapaPessoas.remover("chata");
		mapaPessoas.adicionar("legal", new Pessoa(1, "Matheus"));
		System.out.println(mapaPessoas);
		mapaPessoas.remover("chata");
	}

	private static void fazerConjunto() {
		Conjunto<Pessoa> conjuntosPessoas = new Conjunto<Pessoa>();
		System.out.println(conjuntosPessoas.estaVazio());
		System.out.println(conjuntosPessoas.inserir(new Pessoa(1, "Yohan")));
		System.out.println(conjuntosPessoas);
		System.out.println(conjuntosPessoas.inserir(new Pessoa(2, "Yohan")));
		System.out.println(conjuntosPessoas);
	}

	private static void fazerFila() {
		Fila<Pessoa> filaPessoas = new Fila<Pessoa>();
		System.out.println(filaPessoas.estaVazia());
		filaPessoas.enfileirar(new Pessoa(1, "Joao"));
		filaPessoas.enfileirar(new Pessoa(2, "Yohan"));
		filaPessoas.enfileirar(new Pessoa(3, "Camila"));
		System.out.println(filaPessoas);
		Pessoa p1 = filaPessoas.desfileirar();
		System.out.println(p1.toString());
		System.out.println(filaPessoas);
	}

	private static void fazerPilha() {
		Pilha<Pessoa> pilhaPessoas = new Pilha<Pessoa>();
		System.out.println(pilhaPessoas.estaVazia());
		pilhaPessoas.empilhar(new Pessoa(1, "Joao"));
		pilhaPessoas.empilhar(new Pessoa(2, "Yohan"));
		pilhaPessoas.empilhar(new Pessoa(3, "Camila"));
		pilhaPessoas.empilhar(new Pessoa(4, "Elisa"));
		Pessoa p1 = pilhaPessoas.desempilhar();
		System.out.println(p1.toString());
	}

	private static void fazerListaDuplamenteLigada() {
		ListaDuplamenteLigada<Pessoa> lista = new ListaDuplamenteLigada<Pessoa>();
		lista.inserir(new Pessoa(1, "Joao"));
		lista.inserir(new Pessoa(2, "Leticia"));
		Pessoa p1 = new Pessoa(3, "Yohan");
		lista.inserir(p1);
		lista.inserir(new Pessoa(5, "Camila"));
		lista.inserir(new Pessoa(6, "Jeferson"));
		lista.inserir(new Pessoa(7, "Thais"));
		lista.inserir(new Pessoa(8, "Tulio"));
		System.out.println(lista.recuperar(3));

		System.out.println(lista.indice(p1));
		System.out.println(lista.contem(p1));

		lista.remover(p1);
		System.out.println(lista);
		lista.remover(0);
		System.out.println(lista);

		for (int i = 0; i < lista.tamanho(); i++) {
			System.out.println(lista.recuperar(i).toString());
		}
	}

	private static void fazerListaLigada() {
		ListaLigada<Pessoa> lista = new ListaLigada<Pessoa>();
		lista.inserir(new Pessoa(1, "Joao"));
		lista.inserir(new Pessoa(2, "Leticia"));
		Pessoa p1 = new Pessoa(3, "Yohan");
		lista.inserir(p1);
		lista.inserir(new Pessoa(5, "Camila"));
		lista.inserirEm(2, new Pessoa(6, "Jeferson"));
		lista.inserirPrimeiro(new Pessoa(7, "Thais"));
		lista.inserirUltimo(new Pessoa(8, "Tulio"));
		System.out.println(lista);
		System.out.println(lista.indice(p1));
		System.out.println(lista.contem(p1));

		lista.remover(p1);
		System.out.println(lista);
		lista.remover(0);
		System.out.println(lista);

		for (int i = 0; i < lista.tamanho(); i++) {
			System.out.println(lista.recuperar(i).toString());
		}
	}

	private static void fazerVetor() {
		Vetor<Pessoa> vetorPessoas = new Vetor<Pessoa>(3);
		vetorPessoas.inserir(new Pessoa(1, "Treina Web 1"));
		vetorPessoas.inserir(new Pessoa(2, "Treina Web 2"));
		vetorPessoas.inserir(new Pessoa(3, "Treina Web 3"));
		vetorPessoas.inserir(new Pessoa(4, "Treina Web 4"));
		vetorPessoas.inserir(new Pessoa(5, "Treina Web 5"));
		vetorPessoas.inserirEm(1, new Pessoa(6, "Treina Web 6"));
		System.out.println(vetorPessoas);
		
		for(int i = 0; i < vetorPessoas.tamanho(); i++) {
			System.out.println(vetorPessoas.recuperar(i).getName());			
		}
		
		Pessoa p1 = vetorPessoas.recuperar(1);
		Pessoa p100 = new Pessoa(100, "Treina Web 100");
		System.out.println(vetorPessoas.contem(p1));
		System.out.println(vetorPessoas.contem(p100));
		System.out.println(vetorPessoas.indice(p1));
		System.out.println(vetorPessoas.indice(p100));
		
		vetorPessoas.remover(2);
		System.out.println(vetorPessoas);
		vetorPessoas.remover(p1);
		System.out.println(vetorPessoas);
	}

	private static void fazerGerenciamentoMemoria() {
		int a = 3;
		System.out.println(a);
		int b = a;
		System.out.println();
		b = 2;
		System.out.println("-------------------------------");
		System.out.println(a);
		System.out.println(b);
		System.out.println(a == b);
		System.out.println("********************************");
		Pessoa p1 = new Pessoa(1,  "Treina Web");
		System.out.println(p1);
		Pessoa p2 = p1;
		System.out.println(p2);
		System.out.println("-------------------------------");
		p2.setName("TreinaWeb Modificado");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1 == p2);
	}
}