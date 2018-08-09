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
public class LinkedQueue<E> {

    Nodo inicio;
    Nodo fin;
    int efectivo;

    public LinkedQueue() {
        this.fin = null;
        this.efectivo = 0;
    }

    public boolean isEmpty() {
        return (efectivo == 0);
    }

    public int size() {
        return efectivo;
    }


    public boolean offer(Object e) {
        Nodo temp = new Nodo(e);
        if (this.inicio == null) {
            this.inicio = temp;
            this.fin = temp;
        } else {
            this.fin.setNext(temp);
            this.fin = temp;
        }
        efectivo++;
        return true;
    }

    public Object poll() {
        if (this.inicio == null) {
            return null;
        }
        E temp = (E) this.inicio.getE();
        this.inicio = this.inicio.getNext();
        efectivo--;
        return temp;
  }

    @Override
    public String toString() {
        String q = "";
        Nodo nd = this.inicio;
        int elementos = 0;
        while (elementos < this.efectivo) {
            if (elementos == 0) {
                q += "[";
            } else if (elementos != efectivo-1) {
                q += nd.toString() + ",";
            } else {
                q += nd.toString();
            }
            nd = nd.getNext();
            elementos++;
        }
        q += "]";
        return q;
    }
    
    
}
