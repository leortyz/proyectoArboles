/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import arbol.NodoAB;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Aplicacion;

/**
 *
 * @author Fernando
 */
public class loseScenario {
    private BorderPane bp;
    private VBox vb;
    private HBox hb1;
    private HBox hb2;
    private HBox hb3;
    private Label tittle;
    private Label lose1;
    private Label lose2;
    private Label lose3;
    private TextField tf1;
    private TextField tf2;
    private TextField tf3;
    private Button guardar;
    private FileManagement fm;
    
    public loseScenario(){
        bp=new BorderPane();
        setUpScenario();
        setUpLabels();
        Aplicacion.setBackground(bp,constant.Constant.WALLPAPER0);
    }
    
    private void setUpScenario(){
        fm=new FileManagement();
        tittle=new Label("Ayúdame a mejorar mi predicción");
        tittle.setFont(new Font("Times New Roman", 30));
        lose1=new Label("¿En que animal estabas pensando?:");
        lose1.setFont(new Font("Times New Roman", 20));
        tf1=new TextField();
        hb1=new HBox(); hb1.getChildren().addAll(lose1, tf1);
        lose2=new Label("Escriba una pregunta que me ayude a indentificarlo:");
        lose2.setFont(new Font("Times New Roman", 20));
        tf2=new TextField();
        hb2=new HBox(); hb2.getChildren().addAll(lose2, tf2);
        lose3=new Label("Para el animal que estaba pensando, la repuesta a la pregunta es: ¿si o no?");
        lose3.setFont(new Font("Times New Roman", 15));
        tf3=new TextField();
        hb3=new HBox(); hb3.getChildren().addAll(lose3, tf3);
        guardar=new Button("Guardar");
        vb=new VBox(); vb.getChildren().addAll(tittle, hb1, hb2, hb3, guardar);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);
        bp.setCenter(vb);
        bp.setPadding(new Insets(20, 20, 20, 20));
        
        guardar.setStyle(Constant.BUTTON_STYLE2);
        guardar.setMaxSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
        guardar.setOnAction(new ButtonHandler());
    }
    
    private void setUpLabels(){
        tittle.setTextFill(Color.WHITE);
        lose1.setTextFill(Color.WHITE);
        lose2.setTextFill(Color.WHITE);
        lose3.setTextFill(Color.WHITE);

    }
    
    
    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(event.getSource()==guardar){
                if(!tf1.getText().equals("") && !tf2.getText().equals("") && !tf3.getText().equals("") && (tf3.getText().toLowerCase().equals("si") || tf3.getText().toLowerCase().equals("no"))){
                    String tmp=GameWindow.nodo.getData();
                    if(tf3.getText().toLowerCase().equals("si")){
                        GameWindow.nodo.setData("#P "+tf2.getText().toLowerCase());
                        NodoAB<String> si=new NodoAB<>("#R "+tf1.getText().toLowerCase());
                        NodoAB<String> no=new NodoAB<>(tmp);
                        GameWindow.nodo.setIzq(si);
                        GameWindow.nodo.setDer(no);
                        fm.writeFile(Constant.DATOS_TXT);
                        Aplicacion.setUpAgainWindow();
                    }
                    else if(tf3.getText().toLowerCase().equals("no")){
                        GameWindow.nodo.setData("#P "+tf2.getText().toLowerCase());
                        NodoAB<String> si=new NodoAB<>(tmp);
                        NodoAB<String> no=new NodoAB<>("#R "+tf1.getText().toLowerCase());
                        GameWindow.nodo.setIzq(si);
                        GameWindow.nodo.setDer(no);
                        fm.writeFile(Constant.DATOS_TXT);
                        Aplicacion.setUpAgainWindow();
                    }
                    
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Campo vacío o incorrecto");
                    alert.setContentText("Llene todos los campos de texto y asegurese de responder Si o No en la tercera pregunta.");
                    alert.showAndWait();
                }
            }
        }
        
    }
    
    public Pane getRoot(){
        return bp;
    }
    
}
