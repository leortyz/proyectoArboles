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
public class Vendedor {
    
    private final BorderPane bp;
    private VBox vb;
    private Button newV;
    private Button acOf;
    private Button regresar;
    
    public Vendedor(){
        bp=new BorderPane();
        setUpButtons();
        styleForBtn();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER);
    }
    
    public void setUpButtons(){
        vb=new VBox();
        newV=new Button("Ingresar un nuevo Vehiculo");
        acOf=new Button("Aceptar Oferta");
        regresar=new Button("Regresar");
        vb.getChildren().addAll(newV, acOf, regresar);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(5);
        bp.setCenter(vb);
        
        newV.setOnAction(new ButtonHandler());
        acOf.setOnAction(new ButtonHandler());
        regresar.setOnAction(new ButtonHandler());       
    }
    
    public void styleForBtn(){
        newV.setStyle(Constant.BUTTON_STYLE);
        acOf.setStyle(Constant.BUTTON_STYLE);
        regresar.setStyle(Constant.BUTTON_STYLE);
    }
    
    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource()==newV){
                Aplicacion.setUpNuevoIngresoWindow();
            }
            else if(event.getSource()==acOf){
                Aplicacion.setUpAceptarOfertaWindow();
            }
            else if(event.getSource()==regresar){
                Aplicacion.setUpMenuWindow();
            }
        }   
    }
    
    public Pane getRoot(){
        return bp;
    }
    
}
