package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.bens.Aresta;
import model.bens.Digraph;

public class OrdenadorTopologico {
	private int pre[];
	private List<Integer> ordenado = new ArrayList<>();

	private Stack<Integer> visitacao = new Stack<>();

	private Stack<Integer> visitadosEnaoOrdenados = new Stack<>();

	
	 

	public void ordenarTopologico(Digraph g, int v) {

		ordenado.add(v);

		do {

			Integer proximaVertex = comQuemEstaLigado(g, v);
			if (proximaVertex == v) {
				break;
			}
			ordenado.add(proximaVertex);
			v = proximaVertex;
		} while (todosVisitado(g.adjList.size(), ordenado.size()));

		inserirVertextFinal(g);

		ordenarLista(g);
		
		
	}

	private void ordenarLista(Digraph g) {
		 List<List<Aresta>>  auxiliar = new ArrayList<>();
		for (int i = 0; i < g.adj.length; i++) {
			System.out.print("->"+(ordenado.get(i)));
			auxiliar.add(g.adjList.get(ordenado.get(i)));
			
			
		}
		
		g.adjList = auxiliar;
	}
/**
 * inseri os vetext que nao foi mapeados
 * @param g
 */
	private void inserirVertextFinal(Digraph g) {

		for (int i = 0; i < g.adj.length; i++) {

			if (!ordenado.contains(i)) {
				acharOProximoRecursivo(i, g);
				if (visitacao.size() > 0) {
					for (int proximos : visitacao) {
					ordenado.add(proximos);
					}
					ordenado.add(i);
					visitacao.clear();
				} else {
					ordenado.add(i);
				}

			}

		}

	}

	private Integer comQuemEstaLigado(Digraph g, int v) {

		for (Aresta aresta : g.adjList.get(v)) {
			// se eu nao visitei e ou visitei mais nao ordenei
			if (!visitacao.contains(aresta.getX()) && !visitadosEnaoOrdenados.contains(aresta.getX())
					&& g.adjList.get(aresta.getX()).size() > 0) {
				v = possoColocarNaLista(g, v, aresta.getX());
				return v;
			}
		}
		if (visitacao.size() > 0)
			v = visitacao.pop();

		return v;
	}

	/**
	 * regras
	 * 
	 * 1º se tiver vertex indo para ele esse vertex tem q ja ter cido visitado
	 * 
	 * 2º se o vertex visitado ja tiver na ordenacao é por ja ta validado pode
	 * retorna ele e ele so ter um pai
	 * 
	 * @param g
	 * @param x
	 * @param v
	 */
	private Integer possoColocarNaLista(Digraph g, int v, int x) {
		int numeroDePai = quantosPaiEleTem(x, g);
		if (ordenado.contains(v) && numeroDePai >= 1) {
			ordenado.add(x);

			for (Aresta aresta : g.adjList.get(x)) {
				if (g.adjList.get(aresta.getX()).size() == 0) {
					ordenado.add(aresta.getX());
					continue;
				}
				if (aresta.getVisitado() == null) {
					visitacao.push(aresta.getX());
					acharOProximoRecursivo(aresta.getX(), g);

					int proximo = visitacao.pop();
					if (proximo == aresta.getX() && visitacao.size() > 0) {
						visitadosEnaoOrdenados.push(proximo);
						proximo = visitacao.pop();
					}
					return proximo;

				}
			}

		} else if (numeroDePai > 1) {
			visitacao.push(x);
			acharOProximoRecursivo(x, g);
			int proximo = visitacao.pop();
			if (proximo == x) {
				visitadosEnaoOrdenados.push(proximo);
				proximo = visitacao.pop();
			}
			return proximo;
		}

		return null;

	}

	private void acharOProximoRecursivo(int x, Digraph g) {

		for (int i = 0; i < g.adj.length; i++) {
			if (g.adj[i][x] != null && !ordenado.contains(i) && !visitacao.contains(i)) {
				visitacao.push(i);
				acharOProximoRecursivo(i, g);
				break;
			}

		}

	}

	public int quantosPaiEleTem(int x, Digraph g) {
		int cont = 0;
		for (int i = 0; i < g.adj.length; i++) {
			if (g.adj[i][x] != null) {
				cont++;
			}

		}

		return cont;

	}

	private boolean todosVisitado(int size, int size2) {
		if (size == size2) {
			return false;
		}

		return true;
	}

 
	private Integer verificarLigaçoesComOVertece(int x, Digraph d) {
		for (int i = 0; i < d.adj.length; i++) {
			if (d.adj[i][x] != null && pre[i] == -1) {
				System.out.println(i);
				return i;
			}
		}
		return null;
	}

}
