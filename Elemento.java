package arvoreBinaria;

public class Elemento {
	private int valor;
	private Elemento filhoDireita;
	private Elemento filhoEsquerda;
	
	public Elemento(int valor) {
		this.valor = valor;
		this.filhoDireita = null;
		this.filhoEsquerda = null;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public Elemento getFilhoDireita() {
		return filhoDireita;
	}
	
	public void setFilhoDireita(Elemento filhoDireita) {
		this.filhoDireita = filhoDireita;
	}
	
	public Elemento getFilhoEsquerda() {
		return filhoEsquerda;
	}
	
	public void setFilhoEsquerda(Elemento filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}
	
}
