package br.com.estruturadados.main;

import java.util.LinkedList;
import java.util.Scanner;

import br.com.estruturadados.listasligadas.ListaDuplamenteLigada;
import br.com.estruturadados.listasligadas.ListaLigada;
import br.com.estruturadados.modelos.Pessoa;
import br.com.estruturadados.vetores.Vetor;

public class Main {

	public static void main(String[] args) {
		System.out.println("Digite a opção desejada: ");		
		
		System.out.println("1. Gerenciamento de memória");
		System.out.println("2. Vetores");
		System.out.println("3. Lista Ligada");
		System.out.println("4. Lista Duplamente Ligada");
		
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
	}
		scanner.close();
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