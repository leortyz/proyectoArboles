/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.*;

/**
 *
 * @author EduardOrtiz
 * @param <E>
 */
public class Graph<E> {

    public List<Vertex<E>> vertex;
    public int minimalDistance;// add este parametro para poder controlar de manera global la distancia que va a existir entre las ciudades

    public Graph() {
        this.vertex = new LinkedList<>();
        this.minimalDistance=0;
    }

    public int getMinimalDistance() {
        return minimalDistance;
    }

    public void setMinimalDistance(int minimalDistance) {
        this.minimalDistance = minimalDistance;
    }

    public boolean addVertex(E e) {
        if (e == null) {
            return false;
        }
        Vertex<E> v = new Vertex<>(e);
        if (this.vertex.contains(v)) {
            return false;
        }
        this.vertex.add(v);
        return true;
    }

    public Vertex searchVertex(E e) {
        if (e == null || this.vertex.isEmpty()) {
            return null;
        }
        Vertex<E> v = new Vertex<>(e);
        for (int i = 0; i < this.vertex.size(); i++) {
            if (this.vertex.get(i).getData().equals(e)) {
                return this.vertex.get(i);
            }
        }
        return null;
    }

    public boolean addEdge(E start, E end, int weight) {
        Vertex<E> initialVertex = searchVertex(start);
        Vertex<E> finalVertex = searchVertex(end);
        if(initialVertex == null || finalVertex==null)
            return false;
        Edge<E> edge=new Edge<>(initialVertex,finalVertex,weight);
        if(initialVertex.getArc().contains(edge))
            return false;
        initialVertex.getArc().add(edge);
        return true;
    }

    @Override
    public String toString() {
        String v = "Vertex: {";
        for (int i = 0; i < (this.vertex.size()); i++) {
            v += "[" + this.vertex.get(i) + "]";
        }
        v += "}";
        String graph = "Graph: {";
        graph = this.vertex.stream().map((vt) -> {
            String connections = "";
            connections = vt.getArc().stream().map((a) -> "(" + a.start + "," + a.end + ")").reduce(connections, String::concat);
            return connections;
        }).map((connections) -> connections).reduce(graph, String::concat);
        graph += "}";

        return v + "\n" + graph;
    }

    public void clean() {
        this.vertex.forEach((vt) -> {
            vt.setState(false);
        });
    }

    private void dijkstra(E start) {
        if (!this.vertex.isEmpty() && start != null) {
            Vertex<E> initialVertex = this.searchVertex(start);
            PriorityQueue<Vertex<E>> queue = new PriorityQueue<>((Vertex<E> v1, Vertex<E> v2) -> (v1.getDistance() - v2.getDistance()));
            initialVertex.setDistance(0);
            queue.offer(initialVertex);
            while (!queue.isEmpty()) {
                Vertex<E> sequentialVertex = queue.poll();
                sequentialVertex.setState(true);
                ListIterator<Edge<E>> i = sequentialVertex.getArc().listIterator();
                while (i.hasNext()) {
                    Edge<E> e = i.next();
                    Vertex<E> end = e.getEnd();
                    if (!end.isState() && (end.getDistance() > sequentialVertex.getDistance() + e.getWeight())) {
                        end.setDistance(sequentialVertex.getDistance() + e.getWeight());
                        end.setAntecedentVertex(sequentialVertex);
                        queue.offer(end);
                    }
                }
            }
            clean();
        }
    }
    
    public List<E> shortestWay(E start, E end) {
        this.dijkstra(start);
        LinkedList<E> list = new LinkedList<>();
        list.addFirst(end);
        Vertex<E> vf = this.searchVertex(end);
        while (vf.getAntecedentVertex() != null) {
            list.addFirst(vf.getAntecedentVertex().getData());
            vf = vf.getAntecedentVertex();
        }
        this.setMinimalDistance(searchVertex(end).getDistance());//set la distancia minima que tendra el grafo hasta ese punto(end), se corrobora en el metodo toShow
        return list;
    }

    public void toShow(List<E> l, HashMap<String, String> map) {
        //todo esto es la parte que muestra las ciudades, todo eso bonito y demas es gracias a este metodo :v
        int c = 1;
        E o = null;
        for (E e : l) {
            /*if (c != 1) {
                System.out.println(c + ". " + map.get(e) + " \t\t " + (searchVertex(e).getDistance() - searchVertex(o).getDistance()) + " Km from " + map.get(o) + " to " + map.get(e));
            } else {
                System.out.println(c + ". " + map.get(e) + " \t\t " + searchVertex(e).getDistance());
            }*/
            System.out.println(c+". "+map.get(e));
            o = e;
            c++;
        }
    }
}
