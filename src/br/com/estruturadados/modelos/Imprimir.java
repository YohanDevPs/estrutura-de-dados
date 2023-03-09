package br.com.estruturadados.modelos;

public class Imprimir<T> {	
	
	public void exibiArray(Object[] elementos) {
		for (int i = 0; i < elementos.length; i++) {
			System.out.println(elementos[i]);	
		}
	}
}