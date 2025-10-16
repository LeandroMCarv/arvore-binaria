package arvoreBinaria;

public class TestandoArvores {
	public static void main(String[] args) {
		//testando forma recursiva
		ArvoreBinariaRecursiva aBR = new ArvoreBinariaRecursiva();
		aBR.adicionaNo(new Elemento(40));
		aBR.adicionaNo(new Elemento(45));
		aBR.adicionaNo(new Elemento(30));
		aBR.adicionaNo(new Elemento(28));
		aBR.adicionaNo(new Elemento(21));
//		aBR.adicionaNo(new Elemento(18));
//		aBR.adicionaNo(new Elemento(23));
//		aBR.adicionaNo(new Elemento(35));
//		aBR.adicionaNo(new Elemento(34));
//		aBR.adicionaNo(new Elemento(43));
//		aBR.adicionaNo(new Elemento(41));
//		aBR.adicionaNo(new Elemento(44));
//		aBR.adicionaNo(new Elemento(46));
//		aBR.adicionaNo(new Elemento(52));
//		aBR.adicionaNo(new Elemento(47));
//		aBR.adicionaNo(new Elemento(48));
//		aBR.adicionaNo(new Elemento(58));
//		System.out.println(aBR.getRaiz().getFilhoDireita().getFilhoDireita().getValor());
//		aBR.remover(46);
//		System.out.println(aBR.getRaiz().getFilhoDireita().getFilhoDireita().getValor());
//		System.out.println(aBR.getRaiz().getFilhoDireita().getFilhoDireita().getFilhoDireita().getFilhoEsquerda().getValor());
		System.out.println(aBR.contarNos(aBR.getRaiz()));
		System.out.println(aBR.maiorElemento(aBR.getRaiz()));
		System.out.println(aBR.menorElemento(aBR.getRaiz()));
		System.out.println(aBR.somarNos(aBR.getRaiz()));
		System.out.println(aBR.media(aBR.getRaiz()));
	}
}
