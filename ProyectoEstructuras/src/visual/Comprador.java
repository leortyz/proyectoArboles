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
public class Comprador {
    
    private final BorderPane bp;
    private VBox vb;
    private Button ofVeh;
    private Button elOf;
    private Button regresar;
    
    public Comprador(){
        bp=new BorderPane();
        setUpButtons();
        styleForBtn();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER);
    }
    
    public void setUpButtons(){
        vb=new VBox();
        ofVeh=new Button("Ofertar por un vehiculo");
        elOf=new Button("Eliminar Oferta");
        regresar=new Button("Regresar");
        vb.getChildren().addAll(ofVeh, elOf, regresar);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(5);
        bp.setCenter(vb);
        
        ofVeh.setOnAction(new ButtonHandler());
        elOf.setOnAction(new ButtonHandler()); 
        regresar.setOnAction(new ButtonHandler());
    }
    
    public void styleForBtn(){
        ofVeh.setStyle(Constant.BUTTON_STYLE);
        elOf.setStyle(Constant.BUTTON_STYLE);
        regresar.setStyle(Constant.BUTTON_STYLE);
    }
    
    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource()==ofVeh){
                Aplicacion.setUpNuevaOfertaWindow();
            }
            else if(event.getSource()==elOf){
                Aplicacion.setUpEliminarOferta();
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
