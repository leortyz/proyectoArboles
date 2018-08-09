/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import constant.Constant;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.Aplicacion;

/**
 *
 * @author RODRIGUEZ
 */
public class Menu {
    
    private final BorderPane bp;
    private VBox vb;
    private Button vendedor;
    private Button comprador;
    private Button exit;
    
    public Menu(){
        bp=new BorderPane();
        setUpButtons();
        styleForBtn();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER);
    }
    
    public void setUpButtons(){
        vb=new VBox();
        vendedor=new Button("Vendedor");
        comprador=new Button("Comprador");
        exit=new Button("Salir");
        vb.getChildren().addAll(vendedor, comprador, exit);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(5);
        bp.setCenter(vb);
        
        vendedor.setOnAction(new ButtonHandler());
        comprador.setOnAction(new ButtonHandler());
        exit.setOnAction(new ButtonHandler());       
    }
    
    public void styleForBtn(){
        vendedor.setStyle(Constant.BUTTON_STYLE);
        comprador.setStyle(Constant.BUTTON_STYLE);
        exit.setStyle(Constant.BUTTON_STYLE);
    }
    
    public Pane getRoot(){
        return bp;
    }
    
    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource()==vendedor){
                Aplicacion.setUpVendendorWindow();
            }
            else if(event.getSource()==comprador){
                Aplicacion.setUpCompradorWindow();
            }
            else if(event.getSource()==exit){
                Aplicacion.closeApp();
            }
        }   
    }
    
}
