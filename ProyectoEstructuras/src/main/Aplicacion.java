/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import constant.Constant;
import visual.Comprador;
import visual.Menu;
import visual.Vendedor;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import visual.IngresoVehiculo;
import visual.AceptarOferta;
import visual.AutenticacionUsuarios;
import visual.CrearUsuario;
import visual.EliminarOferta;
import visual.IngresoOferta;
import visual.OfertaComprador;

/**
 *
 * @author RODRIGUEZ
 */
public class Aplicacion extends Application{
    static Scene myScene;

    @Override
    public void start(Stage stage) throws Exception {
        AutenticacionUsuarios au=new AutenticacionUsuarios();
        setUpFirstScene(au);
        stage.setTitle("VENTA DE AUTOS");
        stage.setScene(myScene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void setBackground(Pane pane,String filename){
            Background wallpaper=new Background(new BackgroundImage(new Image(filename,Constant.APP_ANCHO,Constant.APP_ALTO,false,false),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,
            new BackgroundSize(Constant.APP_ANCHO,Constant.APP_ALTO,false,false,true,true)));
            pane.setBackground(wallpaper);       
    }
    
    private static void setUpFirstScene(AutenticacionUsuarios au){
       myScene=new Scene(au.getRoot(), Constant.APP_ANCHO, Constant.APP_ALTO); 
    }
    
    public static void setUpMenuWindow(){
        Menu mw=new Menu();
        myScene.setRoot(mw.getRoot());
    }
    
    public static void setUpCrearUsuario(){
        CrearUsuario cr=new CrearUsuario();
        myScene.setRoot(cr.getRoot());
    }
    
    public static void setUpEliminarOferta(){
        EliminarOferta eo=new EliminarOferta();
        myScene.setRoot(eo.getRoot());
    }
    
    public static void setUpAutenticacionWindow(){
        AutenticacionUsuarios au=new AutenticacionUsuarios();
        myScene.setRoot(au.getRoot());
    }
    
    public static void setUpVendendorWindow(){
        Vendedor vd=new Vendedor();
        myScene.setRoot(vd.getRoot());
    }
    
    public static void setUpCompradorWindow(){
        Comprador cp=new Comprador();
        myScene.setRoot(cp.getRoot());
    }
    
    public static void setUpNuevoIngresoWindow(){
        IngresoVehiculo iv=new IngresoVehiculo();
        myScene.setRoot(iv.getRoot());
    }
    
    public static void setUpNuevaOfertaWindow(){
        IngresoOferta io=new IngresoOferta();
        myScene.setRoot(io.getRoot());
    }
    
    public static void setUpAceptarOfertaWindow(){
        AceptarOferta ao=new AceptarOferta();
        myScene.setRoot(ao.getRoot());
    }
    
    public static void setUpOfertaCompradorWindow(){
        OfertaComprador oc=new OfertaComprador();
        myScene.setRoot(oc.getRoot());
    }
    
    public static void closeApp(){
        Platform.exit();
    }
    
    
    
}
