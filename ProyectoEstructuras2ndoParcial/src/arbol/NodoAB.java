/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author EduardOrtiz
 * @param <E>
 */
public class NodoAB<E> {
    E data;
    NodoAB<E> izq;
    NodoAB<E> der;

    public NodoAB(E data) {
        this.data = data;
        this.izq=null;
        this.der=null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodoAB<E> getIzq() {
        return izq;
    }

    public void setIzq(NodoAB<E> izq) {
        this.izq = izq;
    }

    public NodoAB<E> getDer() {
        return der;
    }

    public void setDer(NodoAB<E> der) {
        this.der = der;
    }

    @Override
    public String toString() {
        return "{" + data + '}';
    }
}
