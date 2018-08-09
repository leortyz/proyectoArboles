/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import arbol.ArbolBinario;
import arbol.NodoAB;
import constant.Constant;
import fileManagement.IFileManagement;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pila.StackLinked;
import visual.GameWindow;


/**
 *
 * @author EduardOrtiz
 */
public class FileManagement implements IFileManagement {
    

    public StackLinked<NodoAB<String>> cargarPila(String nameFile){  
        StackLinked<NodoAB<String>> pila=new StackLinked<>();
        BufferedReader inputStream = null;
        FileReader fr=null;
        try
        { 
            //InputStream in = this.getClass().getResourceAsStream(nameFile); 
            fr=new FileReader(nameFile);
            inputStream = new BufferedReader(fr);
            String line;
            while ((line = inputStream.readLine()) != null) {
                NodoAB<String> nodo=new NodoAB<>(line);
                pila.push(nodo); 
            }
            

        }
        catch(FileNotFoundException e)
        {
          System.out.println("File " + nameFile + " not found.");
        }
        catch(IOException e)
        {
           System.out.println("Error reading from file " + nameFile);
        }
        
        finally{
            try {
  
                if(inputStream!=null){
                    inputStream.close();   
                }
                
                
            } catch (IOException ex) {

               Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        }
        return pila;
    }
    
    public ArbolBinario<String> cargarArbol(StackLinked<NodoAB<String>> pila){
        ArbolBinario<String> arbol=new ArbolBinario<>();
        NodoAB<String> nodoDer=null;
        NodoAB<String> nodoIzq=null;
        while(pila.size()>1){
            NodoAB<String> info=pila.peek();
            if(info.getData().equals("#P es un ave?")){
                nodoDer=pila.pop();
                
            }
            else if(info.getData().equals("#P es un animal domestico?")){
                nodoIzq=pila.pop();
            }
            else{
                NodoAB<String> der=pila.pop();
                NodoAB<String> izq=pila.pop();
                NodoAB<String> root=pila.pop();
                System.out.println(der.getData());
                System.out.println(izq.getData());
                System.out.println(root.getData());
                System.out.println("\n");
                if(root.getData().startsWith("#R")){
                    NodoAB<String> extra=pila.pop();
                    System.out.println("extra"+extra.getData());
                    extra.setIzq(root);
                    extra.setDer(izq);
                    pila.push(extra);
                    pila.push(der);
                }
                else{
                    root.setIzq(izq);
                    root.setDer(der);
                    pila.push(root); 
                }
            }
        }   
        if(pila.size()==1){
            NodoAB<String> rootArbol=pila.pop();
            rootArbol.setIzq(nodoIzq);
            rootArbol.setDer(nodoDer);
            arbol.setRaiz(rootArbol);
            
        }
        return arbol;
    }
 
        /*NodoAB<String> nIz = null;
        NodoAB<String> nDr=null;
        NodoAB<String> n=null;
        while(pila.size()>1){
            NodoAB<String> n1=pila.pop();
            NodoAB<String> n2=pila.pop();
            NodoAB<String> n3=pila.pop();
                
            if(n3.getData().equals("#P es un ave?")){
                 n3.setDer(n1);
                n3.setIzq(n2);
                nDr=n3;
            }
            else if(n3.getData().equals("#P es un animal domestico?")){
                n3.setDer(n1);
                n3.setIzq(n2);
                nIz=n3;
            }
            else{
                n3.setDer(n1);
                n3.setIzq(n2);
                pila.push(n3);
            }
            }        
        NodoAB<String> rootArbol=pila.pop();
        rootArbol.setIzq(nIz);
        rootArbol.setDer(nDr);
        arbol.setRaiz(rootArbol);
        
     
        
        return arbol;*/
        
    /*public ArbolBinario<String> cargarDatos(StackLinked<NodoAB<String>> pila){
        ArbolBinario<String> arbol=new ArbolBinario<>();
        NodoAB<String> nIz = null;
        NodoAB<String> nDr=null;
        NodoAB<String> n=null;
        int c=0;
        while(c<numeroLineas()-1){
            c+=2;
            NodoAB<String> n1=pila.pop();
            NodoAB<String> n2=pila.pop();
            NodoAB<String> n3=pila.pop();
                
            if(n1.getData().equals("#P es un ave?")){
                nDr=n1;
                pila.push(n3);
                pila.push(n2);
            }
            else if(n1.getData().equals("#P es un animal domestico?")){
                nIz=n1;
                pila.push(n3);
                pila.push(n2);
            }
            else if(n1.getData().startsWith("#R")&& n2.getData().startsWith("#R")&& n3.getData().startsWith("#P")){
                n3.setDer(n1);
                n3.setIzq(n2);
                pila.push(n3);
            }
                
            else if(n1.getData().startsWith("#P")&& n2.getData().startsWith("#P")&& n3.getData().startsWith("#P")){
                n3.setDer(n1);
                n3.setIzq(n2);
                pila.push(n3);
            }
            else if(n1.getData().startsWith("#P")&& n2.getData().startsWith("#R")&& n3.getData().startsWith("#P")){
                n3.setDer(n1);
                n3.setIzq(n2);
                pila.push(n3);
                }
            else if(n1.getData().startsWith("#R")&& n2.getData().startsWith("#P")&& n3.getData().startsWith("#P")){
                n3.setDer(n1);
                n3.setIzq(n2);
                pila.push(n3);
            }
            else {
                NodoAB<String> n4=pila.pop();
                n4.setDer(n2);
                n4.setIzq(n3);
                pila.push(n4);
                pila.push(n1);   
            } 
        }        
        NodoAB<String> rootArbol=pila.pop();
        rootArbol.setIzq(nIz);
        rootArbol.setDer(nDr);
        arbol.setRaiz(rootArbol);
            
        
        return arbol;
    }
    
    public static int numeroLineas(){
        int numeroLineas = 0;
        try{
            FileReader fr = new FileReader("datos.txt");
            BufferedReader bf = new BufferedReader(fr);
            String sCadena;
 
            while ((sCadena = bf.readLine())!=null) {
                numeroLineas++;
            }
        }
        catch(FileNotFoundException e){}
        catch(IOException f){}
        return numeroLineas;
    } */
    
    
    public void writeFile(String nameFile){        
        PrintWriter outputStream = null;
        FileOutputStream fs=null;
        try
        {
            //fs=new FileOutputStream("C:/Users/Fernando/Documents/datos.txt");
            outputStream =new PrintWriter(nameFile);
            outputStream.write("");
            preOrden(GameWindow.arbol.getRaiz(),outputStream);
            
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file out.txt."+ e.getMessage());

        }finally{
            if(outputStream!=null){
                outputStream.close();
            }
  
        }
            
        }
    
    
     
     private void preOrden(NodoAB<String> nodo, PrintWriter pw){
        if(nodo!=null){
            pw.println(nodo.getData());
            preOrden(nodo.getIzq(),pw);
            preOrden(nodo.getDer(),pw);
        }
    }
    
    
    
}
