package controller;

import model.OrdenadorTopologico;
import model.bens.Digraph;

public class MainController {

	public static void main(String[] args) {
		Digraph d = new Digraph(13);

		d.digraphInsertAList(0, 6, 1);
		d.digraphInsertAList(0, 5, 1);
		d.digraphInsertAList(0, 1, 1);
                                   
		d.digraphInsertAList(2, 0, 1);
		d.digraphInsertAList(2, 3, 1);
                                   
		d.digraphInsertAList(3, 5, 1);
                                   
		d.digraphInsertAList(5, 4, 1);
                                   
		d.digraphInsertAList(6, 4, 1);
		d.digraphInsertAList(6, 9, 1);
                                   
		d.digraphInsertAList(7, 6, 1);
                                   
		d.digraphInsertAList(8, 7, 1);
                                   
		d.digraphInsertAList(9, 10,1);
		d.digraphInsertAList(9, 11,1);
		d.digraphInsertAList(9, 12,1);
                                   
		d.digraphInsertAList(11, 12,1 );
		
		OrdenadorTopologico ordenadorTopologico = new OrdenadorTopologico(13);
		ordenadorTopologico.dfs(d, 8);

	}
}
