/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileManagement;

import visual.FileManagement;
import arbol.ArbolBinario;
import arbol.NodoAB;
import constant.Constant;
import pila.StackLinked;


/**
 *
 * @author EduardOrtiz
 */
public class pruebaFile {

    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FileManagement f=new FileManagement();
        StackLinked<NodoAB<String>> pila=f.cargarPila(Constant.DATOS_TXT);
        ArbolBinario<String> arbol=f.cargarArbol(pila);
        arbol.preOrden();
        
    }
    
    
}
