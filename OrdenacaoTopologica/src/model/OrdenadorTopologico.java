package model;

import java.util.ArrayList;
import java.util.List;

import model.bens.Aresta;
import model.bens.Digraph;

public class OrdenadorTopologico {
	private int pre[];
	private int cont;
	private List<List<Aresta>> ordenado = new ArrayList<>();

	public OrdenadorTopologico(int grafoTamanho) {

		pre = new int[grafoTamanho];
	}

	public void dfs(Digraph G, int v) {
		cont = 0;

		for (int i = 0; i < pre.length; i++) {
			pre[i] = -1;

		}
		List<List<Aresta>> arestas = G.adjList;
		while (v < arestas.size()) {
			if (pre[v] == -1) {
				DFSRecursivo(G, G.adjList.get(v), v);
			}
			v++;
		}

		for (int i = 0; i < pre.length; i++) {
			System.out.print(String.format("  %d", i));
		}
		System.out.println("\n");
		for (int i = 0; i < pre.length; i++) {
			System.out.print(String.format("  %d", pre[i]));
		}

	}

	private void DFSRecursivo(Digraph g, List<Aresta> list, int v) {
		int w;
		pre[v] = cont++; // (pega valor, depois incrementa)
		for (w = 0; w < list.size(); w++) {
			Integer verticeAntecessor = verificarLigaçoesComOVertece(list.get(w).getX(), g);
			if (verticeAntecessor != null) {
				list = g.adjList.get(verticeAntecessor);
				DFSRecursivo(g, list, verticeAntecessor);

			}

			if (g.adjList.get(v).size() != 0 && pre[list.get(w).getX()] == -1) {
				int provisorio = list.get(w).getX();
				list = g.adjList.get(list.get(w).getX());
				DFSRecursivo(g, list, provisorio);
			}

		}

	}

	private Integer verificarLigaçoesComOVertece(int x, Digraph d) {
		for (int i = 0; i < d.adj.length; i++) {
			if (d.adj[i][x] != null && pre[i]==-1) {
				System.out.println(i);
				return i;
			}
		}
		return null;
	}

	public List<List<Aresta>> getOrdenado() {
		return ordenado;
	}

	public void setOrdenado(List<List<Aresta>> ordenado) {
		this.ordenado = ordenado;
	}

}
