/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileManagement;

import LinkedList.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import vehicle.Oferta;
import vehicle.Vehiculo;

/**
 *
 * @author EduardOrtiz
 */
public class FileManagement implements IFileManagement {

     
    
    //METODO MODIFICADO PARA LEER
    public LinkedList readFile3(String nameFile){        
        BufferedReader inputStream = null;
        LinkedList lista = new LinkedList<>();
        Vehiculo v;
        Oferta of;
        try
        { 
            InputStream in = this.getClass().getResourceAsStream(nameFile); 
            inputStream = new BufferedReader(new InputStreamReader(in));
            String line;
            if ("/files/autos.txt".equals(nameFile)) {
                while ((line = inputStream.readLine()) != null) {
                    String l[] = line.split("\\|");
                    String placa = l[0];
                    String marca = l[1];
                    String modelo = l[2];
                    String tipoMotor = l[3];
                    int anio = Integer.parseInt(l[4]);
                    String tipo = l[5];
                    int recorrido = Integer.parseInt(l[6]);
                    String color = l[7];
                    String tipoCombustible = l[8];
                    String vidrios = l[9];
                    String transmision = l[10];
                    int precio = Integer.parseInt(l[11]);
                    String imagen = l[12];
                    v = new Vehiculo(placa, marca, modelo, tipoMotor, anio, tipo, recorrido, color, tipoCombustible, vidrios, transmision, precio, imagen);
                    lista.addLast(v);
                }
            } else if ("/files/ofertas.txt".equals(nameFile)) {
                while ((line = inputStream.readLine()) != null) {
                    String l[] = line.split("\\|");
                    String placa = l[0];
                    String correo = l[1];
                    int precio = Integer.parseInt(l[2]);
                    of = new Oferta(placa, correo, precio);
                    lista.addLast(of);
                }
            }
        }
        catch(FileNotFoundException e)
        {
          System.out.println("File " + nameFile + " not found.");
        }
        catch(IOException e)
        {
           System.out.println("Error reading from file " + nameFile);
        }finally{
            try {
                if(inputStream!=null){
                    inputStream.close();
                    
                }
            } catch (IOException ex) {
               Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return lista;
    }
    
    public void eliminarLinea(String fileName, String placa){
        BufferedReader inputStream=null;
        PrintWriter outputStream=null;
        FileOutputStream fs=null;
        String linea;
        String fname;
        File file=null;
        File temp=null;
        String fnameNew;
        File f2=null;
        try{
            if("/files/ofertas.txt".equals(fileName)){
                fname="src/files/ofertas.txt";
                file=new File(fname);
                temp=new File("/files/ofertasprueba.txt");
                fnameNew="src/files/ofertasprueba.txt";
                f2=new File(fnameNew);
            }else if("/files/autos.txt".equals(fileName)){
                fname="src/files/autos.txt";
                file=new File(fname);
                temp=new File("/files/autosprueba.txt");
                fnameNew="src/files/autosprueba.txt";
                f2=new File(fnameNew);
            }
            InputStream in = this.getClass().getResourceAsStream(fileName); 
            inputStream = new BufferedReader(new InputStreamReader(in));
            fs=new FileOutputStream("src"+temp);
            outputStream =new PrintWriter(fs);
            while((linea=inputStream.readLine())!=null){
                String l[]=linea.split("\\|");
                if(l[0].equals(placa)){
                    System.out.println("Linea Eliminada");
                }else{outputStream.println(linea);}
            } 
            
        }catch(FileNotFoundException e1){
            System.out.println(e1.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            
            if(inputStream!=null){
                try {  
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            if(outputStream!=null){
                outputStream.write(""); 
                outputStream.close();
            }
            if(fs!=null){
                try {
                    fs.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        eliminarFichero(file);
        renombrarFichero(f2, file);
        
    }
    
    public void eliminarLineaOfertas(String fileName, String placa,String correo,String precio){
        BufferedReader inputStream=null;
        PrintWriter outputStream=null;
        FileOutputStream fs=null;
        String linea;
        String fname;
        File file=null;
        File temp=null;
        String fnameNew;
        File f2=null;
        try{
            fname="src/files/ofertas.txt";
            file=new File(fname);
            temp=new File("/files/ofertasprueba.txt");
            fnameNew="src/files/ofertasprueba.txt";
            f2=new File(fnameNew);
            InputStream in = this.getClass().getResourceAsStream(fileName); 
            inputStream = new BufferedReader(new InputStreamReader(in));
            fs=new FileOutputStream("src"+temp);
            outputStream =new PrintWriter(fs);
            while((linea=inputStream.readLine())!=null){
                String l[]=linea.split("\\|");
                if(l[0].equals(placa)&& l[1].equals(correo) && l[2].equals(precio)){
                    System.out.println("Linea Eliminada");
                }else{outputStream.println(linea);}
            } 
            
        }catch(FileNotFoundException e1){
            System.out.println(e1.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            if(inputStream!=null){
                try {  
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(outputStream!=null){
                outputStream.write(""); 
                outputStream.close();
            }
            if(fs!=null){
                try {
                    fs.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        eliminarFichero(file);
        renombrarFichero(f2, file);
        
    } 
    
    private void eliminarFichero(File fichero) {
        if (!fichero.exists()) {
            System.out.println("El archivo data no existe.");
        } else {
            boolean eliminar=fichero.delete();
            System.out.println(eliminar);
            System.out.println("El archivo data fue eliminado.");
        }
    }
    
    private void renombrarFichero(File fichero, File newName){
        if(!fichero.exists()) {
            System.out.println("El archivo data no existe.");
        } else {
            boolean renombrar=fichero.renameTo(newName);
            System.out.println(renombrar);
            System.out.println("El archivo data fue renombrado.");
        }
    }
    
    public boolean readFileUsuarios(String nameFile,String user,String password, boolean isUserOnly){        
        BufferedReader inputStream = null;
        
        try
        { 
            InputStream in = this.getClass().getResourceAsStream(nameFile); 
            inputStream = new BufferedReader(new InputStreamReader(in));
            String line;
            if(isUserOnly==false){
                while( (line = inputStream.readLine()) != null ){
                String linea[]=line.split("\\|");
                String usuario=linea[0];
                String contrasenia=linea[1];
                if(user.equals(usuario) && password.equals(contrasenia)){
                    return true;
                }
            }   
            }else{
                while( (line = inputStream.readLine()) != null ){
                String linea[]=line.split("\\|");
                String usuario=linea[0];
                if(user.equals(usuario)){
                    return true;
                }
                }
            }
            
        }
        catch(FileNotFoundException e)
        {
          System.out.println("File " + nameFile + " not found.");
        }
        catch(IOException e)
        {
           System.out.println("Error reading from file " + nameFile);
        }finally{
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
	
        }
        
        return false;
   }
    
    public void writeFileUsuarios(String nameFile,String line){        
        PrintWriter outputStream = null;
        FileOutputStream fs=null;
        try
        {
            fs=new FileOutputStream("src"+nameFile,true);
            outputStream =new PrintWriter(fs);
            outputStream.println(line);
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file out.txt."+ e.getMessage());

        }finally{
            if(outputStream!=null){
                outputStream.close();
            }
            if(fs!=null){
                try {
                    fs.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
            
        }
    
}
