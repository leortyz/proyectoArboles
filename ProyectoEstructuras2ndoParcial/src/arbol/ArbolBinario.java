/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author Administrador
 */
public class ArbolBinario<E> {
    private NodoAB<E> raiz;
     
    public ArbolBinario(){
        raiz=null; 
     }
     
    public boolean isEmpty(){
        return this.raiz==null;
     }
     
    public boolean add(E padre,E element){
        if(this.isEmpty() && padre==null && element!=null){
            NodoAB<E> nodo=new NodoAB<>(element);
            this.raiz=nodo;
            return true;
        }
        else if(padre!=null && element!=null && !this.isEmpty() && searchNodo(element)==null){
            return addInterno(padre,element);
             
        }
        return false;
         
    }
     
    private boolean addInterno(E padre, E element){
            NodoAB<E> ref=searchNodo(padre);
            NodoAB<E> nodo=new NodoAB<>(element);
            if(ref==null){
                return false;
            }
            if(ref.getIzq()==null){
                ref.setIzq(nodo);
                return true;
            }
            else if(ref.getDer()==null){
                ref.setDer(nodo);
                return true;
            }
            else{
                return false;
            }
    }
     
    private NodoAB<E> searchNodo(E element){
        return searchNodoRecursivo(element,this.raiz);
    }
      
    private NodoAB<E> searchNodoRecursivo(E element,NodoAB<E> nodo){
        if(nodo==null){
            return null;
        }
        else if(nodo.getData().equals(element)){
            return nodo;
        }
        NodoAB i=searchNodoRecursivo(element,nodo.getIzq());
        NodoAB d=searchNodoRecursivo(element,nodo.getDer());
        if(i!=null){
            return i;
        }
        else if(d!=null){
            return d;
        }
        return null;
         
    }
     
    public int contarNodos(){
        return contarNodosRecursivo(this.raiz);
    }
     
    private int contarNodosRecursivo(NodoAB<E> nodo){ 
        if(nodo==null){
            return 0;
        }
        return 1+contarNodosRecursivo(nodo.getIzq())+contarNodosRecursivo(nodo.getDer());
    }
     
     
    public int altura(){
        return alturaRecursivo(this.raiz);
    }
    private int alturaRecursivo(NodoAB<E> nodo){
        if(nodo==null){
            return 0;
        }
        return 1+Math.max(alturaRecursivo(nodo.getIzq()),alturaRecursivo(nodo.getDer()));
        
         
    }
    
    public boolean contains(E element){
        return containsRecursivo(element,this.raiz);
    }
     
    private boolean containsRecursivo(E element,NodoAB<E> nodo){
        if(nodo==null){
            return false;
        }
        else if(nodo.getData().equals(element)){
            return true;
        }
        return containsRecursivo(element,nodo.getIzq()) || containsRecursivo(element,nodo.getDer());

     }
     
     
     
     public void preOrden(){
        preOrden(this.raiz);
     }
     
     private void preOrden(NodoAB<E> nodo){
        if(nodo!=null){
            System.out.print(nodo.getData()+" ");
            preOrden(nodo.getIzq());
            preOrden(nodo.getDer());
        }
    }
     
    public void enOrden(){
        enOrden(this.raiz);
    }
     
    private void enOrden(NodoAB<E> nodo){
        if(nodo!=null){
            enOrden(nodo.getIzq());
            System.out.print(nodo.getData()+" ");
            enOrden(nodo.getDer());
        }
    }
     
    public void postOrden(){
        postOrden(this.raiz);
    }
    private void postOrden(NodoAB<E> nodo){
        if(nodo!=null){
            postOrden(nodo.getIzq());
            postOrden(nodo.getDer());
            System.out.print(nodo.getData()+" ");
        }
    }
     
    public boolean esLleno(){
        return esLleno(this.raiz);
    }
     
    private boolean esLleno(NodoAB<E> nodo){
        if(nodo==null){
            return true;
        }
        else if((nodo.getIzq()!=null)&&(nodo.getDer()==null)||(nodo.getIzq()==null)&&(nodo.getDer()!=null)){
            return false;
        }
        return esLleno(nodo.getIzq())&& esLleno(nodo.getDer()) && alturaRecursivo(nodo.getIzq())==alturaRecursivo(nodo.getDer());
    }
     
     /*public ArbolBinario<E> espejo(){
         ArbolBinario<E> arbol=new ArbolBinario<>();
         arbol.raiz=espejo(this.raiz);
         return arbol;
     }
     private NodoAB<E> espejo(NodoAB<E> nodo){
         if(nodo==null){
             return null;
         }
         else if(nodo.getDer()==null && nodo.getIzq()==null){
             return nodo;
         }
         else if((nodo.getIzq()!=null)&&(nodo.getDer()==null)){
             NodoAB<E> temp=new NodoAB<>(nodo.getIzq().getData());
             nodo.setDer(temp);
             nodo.getIzq().setData(null);
             
         }
         else if((nodo.getDer()!=null)&&(nodo.getIzq()==null)){
             NodoAB<E> temp=new NodoAB<>(nodo.getDer().getData());
             nodo.setIzq(temp);
             nodo.getDer().setData(null);
             
         }
         else if((nodo.getDer()!=null)&& (nodo.getIzq()!=null)){
            E temp=nodo.getIzq().getData();
            nodo.getIzq().setData(nodo.getDer().getData());
            nodo.getDer().setData(temp);
         }
         
         
         if(espejo(nodo.getIzq())!=null && espejo(nodo.getDer())!=null){
            return nodo;
         
        }
         return null;
         
     }
    
    public boolean arbolesIguales(ArbolBinario<E> arbol1,ArbolBinario<E> arbol2){
        return arbolesIguales(arbol1.raiz,arbol2.raiz);
        
    }
    private boolean arbolesIguales(NodoAB<E> nodo1,NodoAB<E> nodo2){
        if(nodo1==null && nodo2==null){
            return true;
        }
        
        else if(nodo1!=null && nodo2==null){
            return false;
        }
        else if(nodo1==null && nodo2!=null){
            return false;
        }
        else if(!nodo1.getData().equals(nodo2.getData())){
            return false;
        }
        return arbolesIguales(nodo1.getIzq(),nodo2.getIzq()) && arbolesIguales(nodo1.getDer(),nodo2.getDer());
        
    }
    
    public int sumaNivel(int nivel){
        return sumaNivel(this.raiz,nivel,1);
    }
    private int sumaNivel(NodoAB<E> nodo, int nivel,int nivelActual){
        if(nodo==null){
           return 0; 
        }
       
        else if(nivel==nivelActual){
            System.out.println(nodo.getData());
            return 1;
        }
        
        return sumaNivel(nodo.getIzq(),nivel,nivelActual+1)+sumaNivel(nodo.getDer(),nivel,nivelActual+1);*/

    
    public NodoAB<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAB<E> raiz) {
        this.raiz = raiz;
    }
    

     
}
