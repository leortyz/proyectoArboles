/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import constant.Constant;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.Aplicacion;

/**
 *
 * @author EduardOrtiz
 */
public class IngresoOferta {
    
    private final BorderPane bp;
    private final GridPane gp;
    private Label tipoVehiculo;
    private Label recorrido;
    private Label anio;
    private Label precio;
    private Label titulo;
    static TextField inTipoVehiculo;
    static TextField inRecorrido1;
    static TextField inRecorrido2;
    static TextField inAnio1;
    static TextField inAnio2; 
    static TextField inPrecio1;
    static TextField inPrecio2;
    private Text actiontarget;
    private Button buscar;
    private Button regresar;    
    HBox hbButton;    
    
    public IngresoOferta() {
        bp = new BorderPane();
        gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(40);
        gp.setVgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));
        bp.setCenter(gp);
        userInterface();
        location();
        styleForBtn();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER);
    }

    private void userInterface() {
        titulo = new Label("Registro");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tipoVehiculo = new Label("Tipo del vehículo");
        recorrido = new Label("Recorrido");
        anio = new Label("Año");
        precio = new Label("Precio");
        initiateLabels();
        buscar=new Button("Buscar");
        regresar=new Button("Regresar");
        hbButton = new HBox(15);
        hbButton.getChildren().addAll(buscar, regresar);
        hbButton.setAlignment(Pos.BOTTOM_CENTER);
        actiontarget = new Text("Nueva Oferta");
        actiontarget.setFill(Color.FIREBRICK);
        actiontarget.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        
    }
    
    private static void initiateLabels(){
       inTipoVehiculo = new TextField();
       inTipoVehiculo.setPromptText("Ejemplo: Familiar");
       inRecorrido1 = new TextField();
       inRecorrido1.setPromptText("Mínimo");
       inRecorrido2 = new TextField();
       inRecorrido2.setPromptText("Máximo");
       inAnio1 = new TextField();
       inAnio1.setPromptText("Mínimo");
       inAnio2 = new TextField();
       inAnio2.setPromptText("Máximo");
       inPrecio1 = new TextField();
       inPrecio1.setPromptText("Mínimo");
       inPrecio2 = new TextField();
       inPrecio2.setPromptText("Máximo");
       
    }

    private void location() {
        gp.add(titulo, 0, 0, 2, 1);
        gp.add(anio,0,3);
        gp.add(tipoVehiculo,0,1);
        gp.add(recorrido,0,2);        
        gp.add(precio,0,4);
        gp.add(inTipoVehiculo, 1, 1);
        gp.add(inRecorrido1,1,2);
        gp.add(inRecorrido2,2,2);
        gp.add(inAnio1,1,3);
        gp.add(inAnio2,2,3);        
        gp.add(inPrecio1,1,4);
        gp.add(inPrecio2,2,4);        
        gp.add(actiontarget, 1, 9);
        bp.setBottom(hbButton);
    }
    
    private void styleForBtn() {
        buscar.setStyle(Constant.BUTTON_STYLE);
        regresar.setStyle(Constant.BUTTON_STYLE);
        buscar.setOnAction(new ButtonHandler());
        regresar.setOnAction(new ButtonHandler());
    }
    
    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           if(event.getSource()==buscar){
                Aplicacion.setUpOfertaCompradorWindow();
            }
            else if(event.getSource()==regresar){
                Aplicacion.setUpCompradorWindow();
            }
        }   
    }
    
    public Pane getRoot(){
        return bp;
    }
    
}
