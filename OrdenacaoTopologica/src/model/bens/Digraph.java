package model.bens;

import java.util.ArrayList;
import java.util.List;

public class Digraph {

	public Integer adj[][];
	
	public List<List<Aresta>> adjList = new ArrayList<>();
	
	public int a;

	public Digraph(int tamanho) {
		this.adj = new Integer[tamanho][tamanho];
		for (int i = 0; i < tamanho; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	public void dIGRAPHInsertA(Integer v, Integer w, Integer custo) {
		if (v != w && adj[v][w] == null) {
			adj[v][w] = custo;
			a++;
		}
	}
	public void digraphInsertAList(Integer v, Integer w, Integer custo) {
		if (v != w && adjList.get(v)!=null) {
			adj[v][w] = custo;
			a++;
		}
		adjList.get(v).add(new Aresta(w, custo));
	}
}
