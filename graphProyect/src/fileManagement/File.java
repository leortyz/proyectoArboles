/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileManagement;

import graph.Graph;
import graph.Vertex;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author EduardOrtiz
 * @param <E>
 */
public class File<E> {

    public List<String> citiesList() throws FileNotFoundException, IOException {
        List<String> list = new LinkedList<>();
        Vertex<E> v;
        FileReader fr = new FileReader("cities.txt");
        String principalLine;
        BufferedReader bf = new BufferedReader(fr);
        while ((principalLine = bf.readLine()) != null) {
            String l[] = principalLine.split("\\,");
            list.add(l[1].toLowerCase());
        }
        return list;
    }
    
    public HashMap<String, String> loadCities(String fileName) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(fileName);
        String principalLine;
        Map<String, String> cities = new HashMap<>();
        BufferedReader bf = new BufferedReader(fr);
        while ((principalLine = bf.readLine()) != null) {
            String l[] = principalLine.split("\\,");
            cities.put(l[0], l[1]);
        }
        return (HashMap<String, String>) cities;
    }

    public Graph<String> loadGraph(String fileName, HashMap<String, String> cities) throws FileNotFoundException, IOException {
        Graph<String> graph = new Graph<>();
        if (cities.isEmpty()) {
            return null;
        }
        Iterator<String> it = cities.keySet().iterator();
        Vertex<String> v;
        FileReader fr = new FileReader(fileName);
        String principalLine;
        BufferedReader bf = new BufferedReader(fr);
        ArrayList<String[]> list = new ArrayList<>();
        while ((principalLine = bf.readLine()) != null) {
            String l[] = principalLine.split("\\|");
            list.add(l);
        }
        while (it.hasNext()) {
            graph.addVertex(it.next());
        }
        Iterator<String> it2 = cities.keySet().iterator();
        while (it2.hasNext()) {
            String id = it2.next();
            String l[] = list.get(Integer.parseInt(id) - 1);
            for (int i = 1; i < l.length; i++) {
                String l2[] = l[i].split("\\,");
                if (Integer.parseInt(l2[1]) > 0) {
                    graph.addEdge(id, l2[0], Integer.parseInt(l2[1]));
                }
            }
        }
        return graph;
    }
    
    public String searchCityCode(HashMap<String,String> code, String city){
        Iterator<String> it = code.keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            String cityToEvaluate = code.get(key);
            if(city.equalsIgnoreCase(cityToEvaluate)) {
                return key;
            } 
        }
        return null;
    }
}
