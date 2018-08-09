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
public class LinkedList<E> implements List<E> {
    
    private Node<E> first;
    private Node<E> last;
    private int efectivo;
    
    public LinkedList(){
        this.first=this.last=null;
        this.efectivo=0;
    }

    //GETTER Y SETTER
    public Node<E> getFirst() {
        return first;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }

    public Node<E> getLast() {
        return last;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    } 

    @Override
    public boolean isEmpty() {
        return this.efectivo==0;
    }

    @Override
    public int size() {
        return this.efectivo;
    }

    @Override
    public boolean addFirst(E element) {
        if(element!=null){
            Node<E> nodo=new Node(element);
            if(this.isEmpty()){
                this.first=this.last=nodo;
                this.first.setPrevious(this.last);
                this.last.setNext(this.first);
            }else{
                nodo.setNext(this.first);
                this.first.setPrevious(nodo);
                nodo.setPrevious(this.last);
                this.last.setNext(nodo);
                this.first=nodo;
            }
            this.efectivo++;
            return true;
        } return false;
    }

    @Override
    public boolean addLast(E element) {
        if(element!=null){
            Node<E> nodo=new Node<>(element);
            if(this.isEmpty()){
                this.first=this.last=nodo;
                this.first.setPrevious(this.last);
                this.last.setNext(this.first);
            }else{
                this.last.setNext(nodo);
                nodo.setPrevious(this.last);
                this.first.setPrevious(nodo);
                nodo.setNext(this.first);
                this.last=nodo;
            }
            this.efectivo++;
            return true;
        } return false;
    }

    @Override
    public boolean removeFirst() {
        if(this.isEmpty()){
            return false;
        }else if(this.first==this.last){
            this.first.setPrevious(null);
            this.last.setNext(null);
            this.first=this.last=null;
        }else{
            Node<E> temp=this.first.getNext();
            this.first.setNext(null);
            temp.setPrevious(this.last);
            this.last.setNext(temp);
            this.first=temp;
        }
        this.efectivo--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if(this.isEmpty()){
            return false;
        }else if(this.first==this.last){
            this.first.setPrevious(null);
            this.last.setNext(null);
            this.first=this.last=null;
        }else{
            Node<E> temp=this.last.getPrevious();
            this.last.setPrevious(null);
            temp.setNext(this.first);
            this.last=temp;
        }
        this.efectivo--;
        return true;
    }

    @Override
    public boolean contains(E element) {
        if(element!=null){
            Node<E> p=this.first;
            Node<E> q=this.last;
            do{
                if(p.getData().equals(element) || q.getData().equals(element)){
                    return true;
                }
                p=p.getNext();
                q=p.getPrevious();
            }while(q.getNext()!=p && p!=q);
        } return false;
    }

    @Override
    public E get(int index) {
        Node<E> p=this.first;
        int cont=0;
        if(index>=0 && index<this.efectivo){
            do{
                if(cont==index){
                    return p.getData();
                }
                cont++;
                p=p.getNext();
            }while(p!=this.first);
        } return null;
    }

    @Override
    public E getFirstL() {
        if(this.isEmpty()){
            return null;
        }else{
            return this.first.getData();
        }
    }

    @Override
    public E getLastL() {
        if(this.isEmpty()){
            return null;
        }else{
            return this.last.getData();
        }
    }

    @Override
    public List<E> slicing(int inicio, int fin) {
        LinkedList<E> lista= new LinkedList<>();
        Node<E> p=this.first;
        int cont=0;
        if(fin<inicio){
            return null;
        }
        do{
            if(cont>=inicio && cont<fin){
                lista.addLast(p.getData());
            }
            cont++;
            p=p.getNext();
        }while(p!=this.first);
        return lista;
    }

    @Override
    public boolean remove(int index) {
        int cont=0;
        if(index>=0 && index<this.efectivo){
            Node<E> p=this.first;
            do{
                if(cont==index){
                    Node<E> t1=p.getPrevious();
                    Node<E> t2=p.getNext();
                    p.setNext(null);
                    p.setPrevious(null);
                    t1.setNext(t2);
                    t2.setPrevious(t1);
                    this.efectivo--;
                    return true;
                }
                cont++;
                p=p.getNext();
            }while(p!=this.first);
        } return false;
    }

    @Override
    public E set(int index, E element) {
        int cont=0;
        if(element!=null && index>=0 && index<this.efectivo){
            Node<E> p=this.first;
            do{
                if(cont==index){
                    Node<E> temp=p;
                    p.setData(element);
                    return temp.getData();
                }
                cont++;
                p=p.getNext();
            }while(p!=this.first);
        } return null;
    }

    @Override
    public boolean add(int index, E element) {
        int cont=0;
        if(element!=null && index>=0 && index<=this.efectivo){
            Node<E> nodo=new Node(element);
            Node<E> p=this.first;
            if(index==0){
                this.addFirst(element);
            }else{
                do{
                    if(cont==index){
                        Node<E> temp=p.getPrevious();
                        temp.setNext(nodo);
                        nodo.setPrevious(temp);
                        nodo.setNext(p);
                        p.setPrevious(nodo);
                    }
                    cont++;
                    p=p.getNext();
                }while(p!=this.first);
            }
            this.efectivo++;
            return true;
        } return false;
    }

    @Override
    public int indexOf(E element) {
        int cont=0;
        if(element!=null){
            Node<E> p=this.first;
            do{
                if(p.getData().equals(element)){
                    return cont;
                }
                cont++;
                p=p.getNext();
            }while(p!=this.first);
        } return -1;
    }
    
    
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        Node<E> p=this.first;
        do{
            str.append(p.getData());
            if(p.getNext()!=this.first){
                str.append(",");
            }
            p=p.getNext();
        }while(p!=this.first);
        return "["+str+"]";
    }

    @Override
    public Node<E> getNode(int index) {
        Node<E> p=this.first;
        int cont=0;
        if(index>=0 && index<this.efectivo){
            do{
                if(cont==index){
                    return p;
                }
                cont++;
                p=p.getNext();
            }while(p!=this.first);
        } return null;
    }

    
}
