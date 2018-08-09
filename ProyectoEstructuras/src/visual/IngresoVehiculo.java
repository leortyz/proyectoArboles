/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import constant.Constant;
import fileManagement.FileManagement;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import main.Aplicacion;

/**
 *
 * @author EduardOrtiz
 */
public class IngresoVehiculo {

    private final  BorderPane bp;
    private final  GridPane gp;
    private Label titulo;
    private Label placa;
    private Label marca;
    private Label modelo;
    private Label tipoMotor;
    private Label anio;
    private Label tipoVehiculo;
    private Label recorrido;
    private Label color;
    private Label tipoCombustible; 
    private Label vidrios;
    private Label transmision;
    private Label precio;
    private Label imagen;
    private TextField inPlaca;
    private TextField inMarca;
    private TextField inModelo;
    private TextField inTipoMotor;
    private TextField inAnio;
    private TextField inTipoVehiculo;
    private TextField inRecorrido;
    private TextField inColor;
    private TextField inTipoCombustible;
    private TextField inVidrios;
    private TextField inTransmision;
    private TextField inPrecio;
    private String inImagen;
    private Button registro;
    private Button regresar;
    private Button img;
    private HBox hbButton;
    private FileManagement fm;
    private Text actiontarget;
    
    public IngresoVehiculo() {
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
        setUpButtons();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER);
    }

    void userInterface() {
        fm=new FileManagement();
        titulo = new Label("Registro");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        placa = new Label("Placa");
        inPlaca= new TextField();
        marca = new Label("Marca");
        inMarca= new TextField();
        modelo = new Label("Modelo");
        inModelo= new TextField();
        tipoMotor = new Label("Tipo del Motor");
        inTipoMotor= new TextField();
        anio = new Label("Año");
        inAnio= new TextField();
        tipoVehiculo = new Label("Tipo del vehículo");
        inTipoVehiculo= new TextField();
        recorrido = new Label("Recorrido");
        inRecorrido= new TextField();
        color = new Label("Color");
        inColor= new TextField();
        tipoCombustible = new Label("Tipo del Combustible");
        inTipoCombustible= new TextField();
        vidrios = new Label("Vidrios");
        inVidrios= new TextField();
        transmision = new Label("Transmisión");
        inTransmision= new TextField();
        precio = new Label("Precio");
        inPrecio= new TextField();
        imagen = new Label("Imagen");
        img=new Button("Seleccionar Imagen");
        //inImagen= new TextField();
        registro=new Button("Registrar");
        regresar=new Button("Regresar");
        hbButton = new HBox(15);
        hbButton.setAlignment(Pos.BOTTOM_CENTER);
        hbButton.getChildren().addAll(registro, regresar);
        hbButton.spacingProperty().set(10);
        actiontarget = new Text("Nuevo Ingreso");
        actiontarget.setFill(Color.FIREBRICK);
        actiontarget.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
    }
    void location(){
        gp.add(titulo, 0, 0, 2, 1);
        gp.add(placa,0,1);
        gp.add(marca,0,2);
        gp.add(modelo,0,3);
        gp.add(tipoMotor,0,4);
        gp.add(anio,0,5);
        gp.add(tipoVehiculo,0,6);
        gp.add(recorrido,0,7);
        gp.add(color,0,8);
        gp.add(tipoCombustible,0,9);
        gp.add(vidrios,0,10);
        gp.add(transmision,0,11);
        gp.add(precio,0,12);
        gp.add(imagen,0,13);
        gp.add(inPlaca,1,1);
        gp.add(inMarca,1,2);
        gp.add(inModelo,1,3);
        gp.add(inTipoMotor,1,4);
        gp.add(inAnio,1,5);
        gp.add(inTipoVehiculo,1,6);
        gp.add(inRecorrido,1,7);
        gp.add(inColor,1,8);
        gp.add(inTipoCombustible,1,9);
        gp.add(inVidrios,1,10);
        gp.add(inTransmision,1,11);
        gp.add(inPrecio,1,12);        
        gp.add(img,1,13);
        gp.add(hbButton, 1, 14);
        gp.add(actiontarget, 1, 17);
    }
    
    public void setUpButtons(){
        regresar.setOnAction(new ButtonHandler());  
        registro.setOnAction(new ButtonHandler());
        img.setOnAction(new ButtonHandler());
        //registro.setOnMouseClicked(e->registrar(e));
    }
    
    private void registrar(){
        String register="";
        if(esEntero(inRecorrido.getText()) && esEntero(inAnio.getText()) && esEntero(inPrecio.getText())){
            if(!inPlaca.getText().equals("") && !inMarca.getText().equals("") && !inModelo.getText().equals("") &&
               !inTipoMotor.getText().equals("") && !inAnio.getText().equals("") && !inTipoVehiculo.getText().equals("") &&
               !inRecorrido.getText().equals("") && !inColor.getText().equals("") && !inTipoCombustible.getText().equals("") &&
               !inVidrios.getText().equals("") && !inTransmision.getText().equals("") && !inPrecio.getText().equals("") &&
               inImagen!=null){            
                register+=inPlaca.getText();
                register+="|";
                register+=inMarca.getText();
                register+="|";
                register+=inModelo.getText();
                register+="|";
                register+=inTipoMotor.getText();
                register+="|";
                register+=inAnio.getText();
                register+="|";
                register+=inTipoVehiculo.getText();
                register+="|";
                register+=inRecorrido.getText();
                register+="|";
                register+=inColor.getText();
                register+="|";
                register+=inTipoCombustible.getText();
                register+="|";
                register+=inVidrios.getText();
                register+="|";
                register+=inTransmision.getText();
                register+="|";
                register+=inPrecio.getText();
                register+="|";
                register+=inImagen;
                //register+="\n";
                fm.writeFileUsuarios("/files/autos.txt", register);
                actiontarget.setText("Registro Sastifactorio");
                Aplicacion.setUpVendendorWindow();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Casillero vacío");
                alert.setContentText("Ingrese todos los datos pedidos");
                alert.showAndWait();
            } 
        }else{
            if(!esEntero(inRecorrido.getText()) || !esEntero(inPrecio.getText()) || !esEntero(inAnio.getText())){
                inRecorrido.setText(""); inPrecio.setText(""); inAnio.setText("");
            }
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Tipo de Dato invalido");
            alert.setContentText("Ingrese los datos adecuadamente");
            alert.showAndWait();       
        }
    }
    
    private boolean esEntero(String num){
        try{
            Integer n=Integer.parseInt(num);
            System.out.println(n);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
    public Pane getRoot(){
        return bp;
    }
    public void styleForBtn(){
        regresar.setStyle(Constant.BUTTON_STYLE);
        registro.setStyle(Constant.BUTTON_STYLE);
    }
    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(event.getSource()==regresar){
                Aplicacion.setUpVendendorWindow();
            }
            else if(event.getSource()==registro){
                registrar();
            }else if(event.getSource()==img){
                FileChooser fc=new FileChooser();
                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.jpg","*.bmp","*.png"));
                File selectedFile=fc.showOpenDialog(null);
                if(selectedFile!=null){
                    inImagen=selectedFile.getPath();
                    System.out.println(inImagen);
                }else{
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Imagen obligatoria");
                    alert.setContentText("Seleccione una imagen");
                    alert.showAndWait();
                }
            }
        }   
    }
    
}
