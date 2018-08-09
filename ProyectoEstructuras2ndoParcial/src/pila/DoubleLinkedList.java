/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

/**
 *
 * @author Fernando
 */
public class DoubleLinkedList <E> implements List<E> {
    private Nodo<E> first,last;
    private int efectivo;
    
    public DoubleLinkedList(){
        this.first=this.last=null;
        this.efectivo=0;
    }

    @Override
    public boolean isEmpty() {
        return efectivo==0;
    }

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public boolean addFirst(E element) {
        Nodo<E> nodo=new Nodo<>(element);
        if(element==null){
            return false;
        }
        else if(this.isEmpty()){
            this.first=this.last=nodo;
        }
        else{
            nodo.setNext(this.first);
            this.first.setPrevious(nodo);
            this.first=nodo;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Nodo<E> nodo=new Nodo<>(element);
        if(element==null){
            return false;
        }
        else if(this.isEmpty()){
            this.first=this.last=nodo;
        }
        else{
            this.last.setNext(nodo);
            nodo.setPrevious(this.last);
            this.last=nodo;
        }
        efectivo++;
        return true;
    }

    @Override
    public E getFirst() {
        if(this.isEmpty())
            return null;
        return this.first.getData();
    }

    @Override
    public E getLast() {
        if(this.isEmpty())
            return null;
        return this.last.getData();
    }

    @Override
    public boolean removeFirst() {
        if(this.isEmpty()){
            return false;
        }
        else if(this.first==this.last){
            this.first=this.last=null;
        }
        else{
            Nodo<E> tmp=this.first.getNext();
            this.first.setNext(null);
            this.first=tmp;
            this.first.setPrevious(null);
  
        }
        efectivo--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if(this.isEmpty()){
            return false;
        }
        else if(this.first==this.last){
            this.first=this.last=null;
        }
        else{
            Nodo<E> tmp=this.last.getPrevious();
            this.last.setPrevious(null);
            this.last=tmp;
            this.last.setNext(null);
        }
        efectivo--;
        return true;
    }

    @Override
    public boolean contains(E element) {
        Nodo <E> p,q;
        p=this.first;
        q=this.last;
        do{
            if(q.getData().equals(element)|| p.getData().equals(element))
                return true;
            p=p.getNext();
            q=q.getPrevious();
        }while(!(q.getNext()==p) && (p!=q));
        return false;
    }

    @Override
    public E get(int index) {
        E data=null;
        int cont=0;
        for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
            if(cont==index)
                data=p.getData();
            cont++;
        }
        return data;
    }

    @Override
    public List<E> slicing(int inicio, int fin) {
        int cont=0;
        List<E> lista=new DoubleLinkedList<>();
        if(this.isEmpty())
            return null;
        else if(efectivo==1){
            lista.addFirst(this.first.getData());
        }
        else if(inicio>=0 && fin<=efectivo){
            for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
                if(cont>=inicio && cont<fin)
                    lista.addLast(p.getData());
                cont++;
            }
        }
        return lista;
    }
    
   

    @Override
    public boolean remove(int index) {
        
        if(this.isEmpty() || index>=efectivo || index<0){
            return false;
        }
        
        else if(index==0){
            this.removeFirst();
        }
        
        else if(index==efectivo-1){
            this.removeLast();
        }
        
        else{
            int cont=0;
            for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
                if(cont==index){
                    Nodo<E> tmp1=p.getNext();
                    Nodo<E> tmp2=p.getPrevious();
                    p.setNext(null);
                    p.setPrevious(null);
                    tmp1.setPrevious(tmp2);
                    tmp2.setNext(tmp1);
                    efectivo--;
                    
                }
                
                cont++;
            }
        }
        
        
        return true;
        
        
    }

    @Override
    public E set(int index, E element) {
        E data=null;
        if(this.isEmpty() || index>=efectivo || index<0 || element==null ){
            return null;
        }
        
        else{
            int cont=0;
            for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
                if(cont==index){
                    data=p.getData();
                    p.setData(element);
                    
                    
                }
                cont++;
            }
            
        }
        return data;
    }

    @Override
    public boolean add(int index, E element) {
        Nodo<E> nodo=new Nodo<>(element);
        if(this.isEmpty() || index>=efectivo || index<0 || element==null ){
            return false;
        }
        else if(index==0){
            this.addFirst(element);
            
        }
        
        else{
            int cont=0;
            for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
                if(cont==index){
                    Nodo<E> tmp2=p.getPrevious();
                    p.setPrevious(nodo);
                    tmp2.setNext(nodo);
                    nodo.setPrevious(tmp2);
                    nodo.setNext(p);
                    efectivo++;
                }
                cont++;
            }
            
        }
        
        return true;
        
        
    }

    @Override
    public int indexOf(E element) {
        int index=-1;
        if(this.isEmpty() || element==null){
            return -1;
        }
        else{
            int cont=0;
            for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
                if(p.getData().equals(element) && index==-1){
                    index=cont;
                }
                cont++;
            }
            
        }
        return index;
        
        
    }
    
    @Override
    public String toString() {
        String str="";
        for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
            if(p.getNext()!=null)
                str+=p.getData()+",";
            else{
                    str+=p.getData();
            }
        }
        return "["+str+"]";
    }
    
}
