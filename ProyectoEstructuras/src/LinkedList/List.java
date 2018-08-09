/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author RODRIGUEZ
 */
public interface List<E> {
    
    public boolean isEmpty();
    public int size();
    public boolean addFirst(E element);
    public boolean addLast(E element);
    public boolean removeFirst();
    public boolean removeLast();
    public boolean contains(E element);
    public E get(int index);
    public Node<E> getNode(int index);
    public E getFirstL();
    public E getLastL();
    public List<E> slicing(int inicio, int fin);
    public boolean remove(int index);
    public E set(int index, E element);
    public boolean add(int index, E element);
    public int indexOf(E element);
    
}
