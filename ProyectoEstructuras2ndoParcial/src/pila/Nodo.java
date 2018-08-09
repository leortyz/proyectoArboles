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
public class Nodo <E> {
    private E data;
    private Nodo<E> previous,next;
    
    public Nodo(E data){
        this.data=data;
        this.previous=this.next=null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Nodo<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Nodo<E> previous) {
        this.previous = previous;
    }

    public Nodo<E> getNext() {
        return next;
    }

    public void setNext(Nodo<E> next) {
        this.next = next;
    }
    
    
    
 

}
