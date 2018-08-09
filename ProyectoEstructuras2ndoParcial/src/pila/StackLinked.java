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
public class StackLinked<E> {
   private DoubleLinkedList<E> lista;
    
    
    public StackLinked(){
        lista=new DoubleLinkedList<>();
 
    }
    
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    
    public boolean push(E data){
        return lista.addLast(data);
    }
    
    public E pop(){
        E element=lista.getLast();
        lista.removeLast();
        return element; 
    }
    
    public int size(){
        return lista.size();
    }
    
    public E peek(){
        return lista.getLast();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
     
}
