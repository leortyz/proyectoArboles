/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author EduardOrtiz
 * @param <E>
 */
public class Edge<E> {
    Vertex<E> start;
    Vertex<E> end;
    int weight;

    public Edge(Vertex<E> start, Vertex<E> end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Vertex<E> getStart() {
        return start;
    }

    public void setStart(Vertex<E> start) {
        this.start = start;
    }

    public Vertex<E> getEnd() {
        return end;
    }

    public void setEnd(Vertex<E> end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + "," + weight + ')';
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (obj == null) {
            return false;
        }
        else if (!(obj instanceof Edge)) {
            return false;
        } 
        Edge other = (Edge<E>) obj;
        
        return this.getStart().equals(other.getStart()) && this.getEnd().equals(other.getEnd());
    }

    
    
}
