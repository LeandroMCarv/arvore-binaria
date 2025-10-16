package arvoreBinaria;

public class ArvoreBinaria {
	private Elemento raiz;

	public Elemento getRaiz() {
		return raiz;
	}

	public void setRaiz(Elemento raiz) {
		this.raiz = raiz;
	}

	public ArvoreBinaria() {
		this.raiz = null;
	}
	
	public void adicionaNo(Elemento novoNo) {
		if(getRaiz()==null) {
			setRaiz(novoNo);
		}else {
			Elemento noTemp = getRaiz();
			while(true) {
				if(novoNo.getValor()>noTemp.getValor()) {
					if(noTemp.getFilhoDireita()==null) {
						noTemp.setFilhoDireita(novoNo);
						break;
					}else {
						noTemp=noTemp.getFilhoDireita();
					}
				}else {
					if(noTemp.getFilhoEsquerda()==null) {
						noTemp.setFilhoEsquerda(novoNo);
						break;
					}else {
						noTemp=noTemp.getFilhoEsquerda();
					}
				}
			}
		}
	}
	
	public boolean verificaSeExiste(int valor) {
		if(this.raiz==null) {
			return false;
		}else {
			Elemento elemento = getRaiz();
			while(elemento!=null) {
				if(valor == elemento.getValor()) {
					System.out.println("Valor encontrado!");
					return true;
				}else if(valor > elemento.getValor()) {
					elemento = elemento.getFilhoDireita();
				}else{
					elemento = elemento.getFilhoEsquerda();
				}
			}
		}
		return false;
	}
	
	public void emOrdem(Elemento atual) {
		if(atual!=null) {
			emOrdem(atual.getFilhoEsquerda());
			System.out.println(atual.getValor());
			emOrdem(atual.getFilhoDireita());
		}
	}
	
	public void posOrdem(Elemento atual) {
		if(atual!=null) {
			posOrdem(atual.getFilhoEsquerda());
			posOrdem(atual.getFilhoDireita());
			System.out.println(atual.getValor());
		}
	}
	
	public void preOrdem(Elemento atual) {
		if(atual!=null) {
			System.out.println(atual.getValor());
			preOrdem(atual.getFilhoEsquerda());
			preOrdem(atual.getFilhoDireita());
		}
	}
	
	public boolean remover(int valor) {
		if(verificaSeExiste(valor)) {
			Elemento elemento = getRaiz();
			Elemento paiDoElemento = null;
			//busca a posicao do elemento
			while(elemento!=null) {
				if(valor == elemento.getValor()) { //encontrou o elemento
					break;
				}else if(valor > elemento.getValor()) { //valor está a direita do elemento
					paiDoElemento = elemento;
					elemento = elemento.getFilhoDireita();
				}else { //valor está a esquerda do elemento
					paiDoElemento = elemento;
					elemento = elemento.getFilhoEsquerda();
				}
			}
			Elemento auxiliar;
			Elemento paiDoAuxiliar = elemento;
			if(elemento.getFilhoDireita()!=null&&elemento.getFilhoEsquerda()!=null) { //tem dois filhos
				auxiliar = paiDoAuxiliar.getFilhoDireita();
				if(auxiliar.getFilhoEsquerda()!=null) {//o auxiliar tem filhos à esquerda
					while(auxiliar.getFilhoEsquerda()!=null) {
						paiDoAuxiliar=auxiliar;
						auxiliar=auxiliar.getFilhoEsquerda();
					}
					if(auxiliar.getFilhoDireita()!=null) {//há filhos à direita do auxiliar que será removido
						elemento.setValor(auxiliar.getValor());
						paiDoAuxiliar.setFilhoEsquerda(auxiliar.getFilhoDireita());//evita que perca a referencias dos filhos à direita
					}else {//não há filhos à direita do auxiliar
						elemento.setValor(auxiliar.getValor());
						paiDoAuxiliar.setFilhoEsquerda(null);
					}
				}else {//nao tem filhos à esquerda
					elemento.setValor(auxiliar.getValor());
					paiDoAuxiliar.setFilhoDireita(auxiliar.getFilhoDireita());
				}
			}else if(elemento.getFilhoDireita()!=null) {//so tem filhos à direita
				auxiliar = paiDoAuxiliar.getFilhoDireita();
				if(auxiliar.getFilhoEsquerda()!=null) {//há valores à esquerda do auxiliar
					while(auxiliar.getFilhoEsquerda()!=null) {
						paiDoAuxiliar=auxiliar;
						auxiliar=auxiliar.getFilhoEsquerda();
					}
					if(auxiliar.getFilhoDireita()!=null) { //existem elementos à direita do auxiliar
						elemento.setValor(auxiliar.getValor());
						paiDoAuxiliar.setFilhoEsquerda(auxiliar.getFilhoDireita());
					}else { //não existem elementos à direita do último à esquerda do auxiliar
						elemento.setValor(auxiliar.getValor());
						paiDoAuxiliar.setFilhoEsquerda(null);
					}
				}else {//não há valores à esquerda do auxiliar
					elemento.setValor(auxiliar.getValor());
					paiDoAuxiliar.setFilhoDireita(auxiliar.getFilhoDireita());
				}
			}else if(elemento.getFilhoEsquerda()!=null) {//so tem filhos à esquerda
				auxiliar = paiDoAuxiliar.getFilhoEsquerda();
				if(auxiliar.getFilhoDireita()!=null) {//o auxiliar tem filhos à direita
					while(auxiliar.getFilhoDireita()!=null) {
						paiDoAuxiliar = auxiliar;
						auxiliar = auxiliar.getFilhoDireita();
					}
					if(auxiliar.getFilhoEsquerda()!=null) {//o auxiliar tem filhos à esquerda
						elemento.setValor(auxiliar.getValor());
						paiDoAuxiliar.setFilhoDireita(auxiliar.getFilhoEsquerda());
					}else {//o auxiliar nao tem filhos à esquerda
						elemento.setValor(auxiliar.getValor());
						paiDoAuxiliar.setFilhoDireita(null);
					}
				}else {//não tem ninguém à direita do auxiliar
					elemento.setValor(auxiliar.getValor());
					paiDoAuxiliar.setFilhoEsquerda(auxiliar.getFilhoEsquerda());
				}
			}else {//nao tem filhos
				if(paiDoElemento!=null) { //o elemento a ser removido é uma folha
					if(elemento.getValor()>paiDoElemento.getValor()) {
						paiDoElemento.setFilhoDireita(null);
					}else {
						paiDoElemento.setFilhoEsquerda(null);
					}
				}else { // so tem a raiz na arvore
					setRaiz(null);
				}
			}
			return true;
		}else {
			return false;
		}
	}
	
	 // Método para contar a quantidade de nós
    public int contarNos(Elemento raiz) {
        if (raiz == null) {
            return 0;
        }
        // Conta o nó atual + quantidade de nós da subárvore esquerda + quantidade de nós da subárvore direita
        return 1 + contarNos(raiz.getFilhoEsquerda()) + contarNos(raiz.getFilhoDireita());
    }
    
    public int somarNos(Elemento raiz) {
    	if(raiz == null) {
    		return 0;
    	}
    	return raiz.getValor() + somarNos(raiz.getFilhoEsquerda()) + somarNos(raiz.getFilhoDireita());
    }
    
    public double media(Elemento raiz) {
    	if(contarNos(raiz)!=0) {
    		return (double) somarNos(raiz)/contarNos(raiz);
    	}
    	System.out.println("Nao ha valores para fazer a media");
    	return 0;
    }
    
    public int maiorElemento(Elemento elemento) {
    	while(elemento.getFilhoDireita()!=null) {
    		elemento = elemento.getFilhoDireita();
    	}
    	return elemento.getValor();
    }
    
    public int menorElemento(Elemento elemento) {
    	while(elemento.getFilhoEsquerda()!=null) {
    		elemento = elemento.getFilhoEsquerda();
    	}
    	return elemento.getValor();
    }
    
    public int quantFolhas(Elemento raiz) {
    	if(raiz==null) {
    		return 0; 
    	}
    	if(raiz.getFilhoDireita()==null&&raiz.getFilhoEsquerda()==null) {
    		return 1;
    	}
    	return quantFolhas(raiz.getFilhoEsquerda()) + quantFolhas(raiz.getFilhoDireita());  
    }
}