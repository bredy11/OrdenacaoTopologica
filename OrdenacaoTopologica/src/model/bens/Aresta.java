package model.bens;

public class Aresta {

	
	private int x;
	private int peso;
	private Boolean visitado;

	public Aresta(int x, int peso) {
		this.x = x;
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Aresta [x=" + x + "]";
	}

	public Boolean getVisitado() {
		return visitado;
	}

	public void setVisitado(Boolean visitado) {
		this.visitado = visitado;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
