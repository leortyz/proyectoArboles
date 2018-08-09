/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import LinkedList.LinkedList;
import LinkedList.Node;
import constant.Constant;
import fileManagement.FileManagement;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Aplicacion;
import vehicle.Oferta;
import vehicle.Vehiculo;

/**
 *
 * @author EduardOrtiz
 */
public class OfertaComprador {

    private final BorderPane bp;
    private GridPane gp;
    private GridPane gp2;
    private GridPane allButton;
    private FileManagement fm;
    private Label titulo;
    private Label placaShow;
    private Label precioShow;
    private Label recorridoShow;
    private Label anioShow;
    private Label vehiculoAO;
    private Label imagen;
    private Button regresar;
    private Button ofAnterior;
    private Button siguiente;
    private Button ofertar;
    private HBox hbButton;
    private HBox hbB;
    private TextField correo;
    private TextField of;
    private LinkedList<Vehiculo> vOferta;
    private Node<Vehiculo> nodo;
    private Label nuevaOferta;

    public OfertaComprador() {
        bp = new BorderPane();
        gp = new GridPane();
        gp2 = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(40);
        gp.setVgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));
        gp2.setAlignment(Pos.CENTER);
        gp2.setHgap(40);
        gp2.setVgap(10);
        gp2.setPadding(new Insets(25, 25, 25, 25));
        bp.setTop(gp);
        bp.setCenter(gp2);
        userInterface();
        location();
        styleForBtn();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER);
        
    }

    public Pane getRoot() {
        return bp;
    }

    private void userInterface() { 
        fm = new FileManagement();
        vOferta = vehiculoOferta(fm.readFile3("/files/autos.txt"));
        nuevaOferta=new Label();
        allButton=new GridPane();
        allButton.setAlignment(Pos.CENTER);
        allButton.setHgap(40);
        allButton.setVgap(10);
        allButton.setPadding(new Insets(25, 25, 25, 25));
        ofertar = new Button("Ofertar");
        regresar = new Button("Regresar");
        ofAnterior=new Button("Vehiculo Anterior");
        siguiente=new Button("Siguiente Vehiculo");
        hbButton = new HBox(15);
        hbB=new HBox(15);
        hbButton.getChildren().addAll(ofertar, regresar);
        hbB.getChildren().addAll(ofAnterior, siguiente);
        hbButton.setAlignment(Pos.BOTTOM_CENTER);
        hbB.setAlignment(Pos.BOTTOM_CENTER);

    }

    private void location() {
        allButton.add(hbB, 0, 0);
        allButton.add(hbButton, 0, 1);
        bp.setBottom(allButton);
        titulo = new Label("Vehiculos Disponibles");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        gp.add(titulo, 0, 0, 2, 1);
        Label w = new Label("Placa");
        w.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Label x = new Label("Precio");
        x.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Label y = new Label("Año");
        y.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Label z = new Label("KM Recorridos");
        z.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        placaShow=new Label();
        precioShow=new Label();
        recorridoShow=new Label();
        anioShow=new Label();
        Label v1A = new Label("Vehiculo a ofertar: ");
        v1A.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Label v2A = new Label("Correo: ");
        v2A.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Label v3A = new Label("Precio a ofertar: ");
        v3A.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        vehiculoAO = new Label();        
        vehiculoAO.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        imagen=new Label();
        correo=new TextField();
        of=new TextField();
        gp2.add(v1A, 0, 2);
        gp2.add(vehiculoAO, 1, 2);
        gp2.add(v2A, 0, 3);
        gp2.add(correo, 1, 3);
        gp2.add(v3A, 0, 4);
        gp2.add(of, 1, 4);
        gp.add(w, 0, 2);
        gp.add(x, 1, 2);
        gp.add(y, 2, 2);
        gp.add(z, 3, 2);
        gp.add(imagen,1, 6,2,1);
        gp.add(placaShow, 0, 4);
        gp.add(precioShow, 1, 4);
        gp.add(recorridoShow, 3, 4);
        gp.add(anioShow, 2, 4);
        if (!vOferta.isEmpty()) {
            nodo = vOferta.getFirst();
            Vehiculo v = nodo.getData();
            placaShow.setText(v.getPlaca());
            vehiculoAO.setText(v.getPlaca());
            precioShow.setText("$"+String.valueOf(v.getPrecio()));
            recorridoShow.setText(String.valueOf(v.getRecorrido()));
            anioShow.setText(String.valueOf(v.getAnio()));
            if(v.getPlaca().equals("BFGM8761") || v.getPlaca().equals("XYLO2596") || v.getPlaca().equals("FBCX6986") || 
               v.getPlaca().equals("CKQB9482") || v.getPlaca().equals("ZARS1545") || v.getPlaca().equals("RFPW0924")){
                Image im=new Image(v.getImagen());
                ImageView iv=new ImageView(im);
                iv.setFitHeight(150);
                iv.setFitWidth(200);
                imagen.setGraphic(iv);
            }else{
                ImageView iv=new ImageView(new Image(new File(v.getImagen()).toURI().toString(),150,200,false,false));
                imagen.setGraphic(iv);
            }
        }
        placaShow.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        precioShow.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        recorridoShow.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        anioShow.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));        
        vehiculoAO.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
    }

    private void styleForBtn() {
        ofertar.setStyle(Constant.BUTTON_STYLE);
        regresar.setStyle(Constant.BUTTON_STYLE);
        ofAnterior.setStyle(Constant.BUTTON_STYLE);
        siguiente.setStyle(Constant.BUTTON_STYLE);
        ofertar.setOnAction(new ButtonHandler());
        regresar.setOnAction(new ButtonHandler());
        ofAnterior.setOnAction(new ButtonHandler());
        siguiente.setOnAction(new ButtonHandler());
    }

    public class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == ofertar) {
                if (correo.getText().isEmpty()) {
                    if(vehiculoAO.getText().equals("") || correo.getText().equals("") || of.getText().equals("")){
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("Campos vacios");
                        alert.setContentText("Ingrese datos en todos los campos");
                        alert.showAndWait();
                    }
                    //Aplicacion.setUpNuevaOfertaWindow();
                } else {
                    try {
                        Oferta oferta = new Oferta(vehiculoAO.getText(), correo.getText(), Integer.parseInt(of.getText()));
                        fm.writeFileUsuarios("/files/ofertas.txt", oferta.toString());
                        nuevaOferta=new Label(oferta.toString());
                        Aplicacion.setUpNuevaOfertaWindow();
                    } catch (NumberFormatException e) {
                        Aplicacion.setUpNuevaOfertaWindow();
                    }
                }
            } else if (event.getSource() == regresar) {
                Aplicacion.setUpCompradorWindow();
            } else if (event.getSource() == ofAnterior) {
                if (nodo.getPrevious() != null) {
                    nodo = nodo.getPrevious();
                    Vehiculo v = nodo.getData();
                    placaShow.setText(v.getPlaca());
                    vehiculoAO.setText(v.getPlaca());
                    precioShow.setText("$"+String.valueOf(v.getPrecio()));
                    recorridoShow.setText(String.valueOf(v.getRecorrido()));
                    anioShow.setText(String.valueOf(v.getAnio()));
                    if(v.getPlaca().equals("BFGM8761") || v.getPlaca().equals("XYLO2596") || v.getPlaca().equals("FBCX6986") || 
                       v.getPlaca().equals("CKQB9482") || v.getPlaca().equals("ZARS1545") || v.getPlaca().equals("RFPW0924")){
                        Image im=new Image(v.getImagen());
                        ImageView iv=new ImageView(im);
                        iv.setFitHeight(150);
                        iv.setFitWidth(200);
                        imagen.setGraphic(iv);
                    }else{
                        ImageView iv=new ImageView(new Image(new File(v.getImagen()).toURI().toString(),150,200,false,false));
                        imagen.setGraphic(iv);
                    }
                }
            } else if (event.getSource() == siguiente) {
                if (nodo.getNext() != null) {
                    nodo = nodo.getNext();
                    Vehiculo v = nodo.getData();
                    placaShow.setText(v.getPlaca());
                    vehiculoAO.setText(v.getPlaca());
                    precioShow.setText("$"+String.valueOf(v.getPrecio()));
                    recorridoShow.setText(String.valueOf(v.getRecorrido()));
                    anioShow.setText(String.valueOf(v.getAnio()));
                    if(v.getPlaca().equals("BFGM8761") || v.getPlaca().equals("XYLO2596") || v.getPlaca().equals("FBCX6986") || 
                       v.getPlaca().equals("CKQB9482") || v.getPlaca().equals("ZARS1545") || v.getPlaca().equals("RFPW0924")){
                        Image im=new Image(v.getImagen());
                        ImageView iv=new ImageView(im);
                        iv.setFitHeight(150);
                        iv.setFitWidth(200);
                        imagen.setGraphic(iv);
                    }else{
                        ImageView iv=new ImageView(new Image(new File(v.getImagen()).toURI().toString(),150,200,false,false));
                        imagen.setGraphic(iv);
                    }
                }
            }
        }
    }

     private LinkedList vehiculoOferta(LinkedList<Vehiculo> vehiculo) {
        LinkedList<Vehiculo> ofertas = new LinkedList<>();
        int anio1, anio2, precio1, precio2, recorrido1, recorrido2;
        Boolean state1 = IngresoOferta.inTipoVehiculo.getText().isEmpty();
        Boolean state2 = IngresoOferta.inAnio1.getText().isEmpty();
        Boolean state3 = IngresoOferta.inAnio2.getText().isEmpty();
        Boolean state4 = IngresoOferta.inPrecio1.getText().isEmpty();
        Boolean state5 = IngresoOferta.inPrecio2.getText().isEmpty();
        Boolean state6 = IngresoOferta.inRecorrido1.getText().isEmpty();
        Boolean state7 = IngresoOferta.inRecorrido2.getText().isEmpty();
        if (state1 && state2 && state3 && state4 && state5 && state6 && state7) {
            return vehiculo;
        } else {
            if (state2) {
                anio1 = 0;
            } else {
                anio1 = Integer.parseInt(IngresoOferta.inAnio1.getText());
            }
            if (state3) {
                anio2 = 1000000;
            } else {
                anio2 = Integer.parseInt(IngresoOferta.inAnio2.getText());
            }
            if (state4) {
                precio1 = 0;
            } else {
                precio1 = Integer.parseInt(IngresoOferta.inPrecio1.getText());
            }
            if (state5) {
                precio2 = 1000000;
            } else {
                precio2 = Integer.parseInt(IngresoOferta.inPrecio2.getText());
            }
            if (state6) {
                recorrido1 = 0;
            } else {
                recorrido1 = Integer.parseInt(IngresoOferta.inRecorrido1.getText());
            }
            if (state7) {
                recorrido2 = 1000000;
            } else {
                recorrido2 = Integer.parseInt(IngresoOferta.inRecorrido2.getText());
            }
            for (int i = 0; i < vehiculo.size(); i++) {
                Vehiculo v = vehiculo.get(i);
                int recorrido = v.getRecorrido();
                if (recorrido >= recorrido1 && recorrido <= recorrido2) {
                    int anio = v.getAnio();
                    if (anio >= anio1 && anio <= anio2) {
                        int precio = v.getPrecio();
                        if (precio >= precio1 && precio <= precio2) {
                            if (state1) {
                                ofertas.addLast(v);
                            } else {
                                String modelo = v.getModelo();
                                if (modelo.equalsIgnoreCase(IngresoOferta.inTipoVehiculo.getText())) {
                                    ofertas.addLast(v);
                                }
                            }
                        }

                    }
                }

            }
            return ofertas;
        }
    }

}
