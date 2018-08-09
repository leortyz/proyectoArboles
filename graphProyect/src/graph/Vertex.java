/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author EduardOrtiz
 * @param <E>
 */
public class Vertex<E> {
    private E data;
    private List<Edge<E>> arc;
    private boolean state;
    private Vertex<E> AntecedentVertex;
    private int distance;
    private int id;

    public Vertex(E data) {
        this.data = data;
        this.arc = new LinkedList<>();
        this.state= false;
        this.AntecedentVertex=null;
        this.distance=Integer.MAX_VALUE;
        this.id=-1;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Vertex<E> getAntecedentVertex() {
        return AntecedentVertex;
    }

    public void setAntecedentVertex(Vertex<E> AntecedentVertex) {
        this.AntecedentVertex = AntecedentVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<Edge<E>> getArc() {
        return arc;
    }

    public void setArc(List<Edge<E>> arc) {
        this.arc = arc;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return (String) data ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (obj == null) {
            return false;
        }
        else if (!(obj instanceof Vertex)) {
            return false;
        } 
        Vertex<E> other = (Vertex<E>) obj;
        
        return this.getData().equals(other.getData());
    }
}
