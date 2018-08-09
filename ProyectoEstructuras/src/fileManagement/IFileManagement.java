/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileManagement;

/**
 *
 * @author EduardOrtiz
 */
public interface IFileManagement {
    static void readFile(String file){};
    static void writeFile(String fileName, String line){};
    static void eliminarLinea(String fileName, String placa){};
    static void getDate(){};
}
