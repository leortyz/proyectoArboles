/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import constant.Constant;
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
import visual.DialogWindow;
import visual.GameWindow;
import visual.MenuPrincipal;
import visual.loseScenario;
import visual.winScenario;
import visual.AgainWindow;

/**
 *
 * @author Fernando
 */
public class Aplicacion extends Application {
    static Scene myScene;

    @Override
    public void start(Stage stage) throws Exception {
        MenuPrincipal mp=new MenuPrincipal();
        setUpFirstScene(mp);
        stage.setTitle("GENIO POLITECNICO");
        stage.setScene(myScene);
        stage.show();
    }
    
    private static void setUpFirstScene(MenuPrincipal mp){
       myScene=new Scene(mp.getRoot(), Constant.APP_ANCHO, Constant.APP_ALTO); 
    }
    
    public static void setBackground(Pane pane,String filename){
            Background wallpaper=new Background(new BackgroundImage(new Image(filename,Constant.APP_ANCHO,Constant.APP_ALTO,false,false),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,
            new BackgroundSize(Constant.APP_ANCHO,Constant.APP_ALTO,false,false,true,true)));
            pane.setBackground(wallpaper);       
    }
    
    public static void setUpDialogWindow(){
        DialogWindow dw=new DialogWindow();
        myScene.setRoot(dw.getRoot());
    }
    
    public static void setUpMenuPrincipal(){
        MenuPrincipal mp=new MenuPrincipal();
        myScene.setRoot(mp.getRoot());
    }
    
    public static void setUpWinScenario(){
        winScenario ws=new winScenario();
        myScene.setRoot(ws.getRoot());
    }
    
    
    public static void setUpGameWindow(){
        GameWindow gw=new GameWindow();
        myScene.setRoot(gw.getRoot());
    }
    
    public static void setUpLoseScenario(){
        loseScenario ls=new loseScenario();
        myScene.setRoot(ls.getRoot());
    }
    
    public static void setUpAgainWindow(){
        AgainWindow awi=new AgainWindow();
        myScene.setRoot(awi.getRoot());
    }
    
    public static void closeApp(){
        Platform.exit();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
