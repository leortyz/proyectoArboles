/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import fileManagement.File;
import graph.Graph;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author EduardOrtiz
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File<String> in = new File<>();
        List<String> citiesList = in.citiesList();
        HashMap<String, String> cities = in.loadCities("cities.txt");
        Graph<String> graph = in.loadGraph("distances.txt", cities);
        System.out.println("¡WELCOME!");
        System.out.println("We will proceed to guide you to your destination by the shortest route from where you are.");
        System.out.print("Please enter the city of departure: ");
        String city1;
        Scanner input1 = new Scanner(System.in);
        city1 = input1.nextLine();
        while (!citiesList.contains(city1.toLowerCase())) {
            System.out.println("The city isn't on the list. In the next update, we'll most likely include it if there is a path to it.");
            System.out.print("Please enter the city of departure: ");
            city1 = input1.nextLine();
        }
        System.out.print("Please enter the city of destination: ");
        String city2;
        Scanner input2 = new Scanner(System.in);
        city2 = input2.nextLine();
        while (!citiesList.contains(city2.toLowerCase())) {
            System.out.println("The city isn't on the list. In the next update, we'll most likely include it if there is a path to it.");
            System.out.print("Please enter the city of destination: ");
            city2 = input1.nextLine();
        }
        List<String> citiesListConnected = graph.shortestWay(in.searchCityCode(cities, city1), in.searchCityCode(cities, city2));
        System.out.println("There are "+graph.getMinimalDistance()+" km of distance between "+city1+" and "+city2+".");
        System.out.println("To go from "+city1+" to "+city2+", you'll have to go through the following cities: ");
        graph.toShow(citiesListConnected, cities);
        System.out.println("¡Have a nice trip!");
        
    }
}
