/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedq;

/**
 *
 * @author EduardOrtiz
 * @param <E>
 */
public class Nodo<E> {
    Object e;
    Nodo Next;

    public Nodo(E o) {
      e = o;
      Next = null;
    }

    public Object getE() {
        return e;
    }

    public void setE(Object e) {
        this.e = e;
    }

    public Nodo getNext() {
        return Next;
    }

    public void setNext(Nodo Next) {
        this.Next = Next;
    }

    @Override
    public String toString() {
        return "" + e ;
    }

}
