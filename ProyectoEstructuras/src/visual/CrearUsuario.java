/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import constant.Constant;
import fileManagement.FileManagement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Aplicacion;

/**
 *
 * @author Fernando
 */
public class CrearUsuario {
    private VBox vb;
    private BorderPane bp;
    private HBox hb;
    private HBox hb1;
    private Button atras;
    private Button crearCuenta;
    private Label lbl;
    private Label lbl1;
    private Label lbl2;
    private TextField text1;
    private PasswordField text2;
    private FileManagement fm;
    
    public CrearUsuario(){
        setUpAutenticacion();
        styleForBtn();
        setUpActions();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER);
        
    }
    
    public void setUpAutenticacion(){
        vb=new VBox();
        hb=new HBox();
        bp=new BorderPane();
        hb1=new HBox();
        fm=new FileManagement();
        lbl=new Label("Crear una cuenta");
        lbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        lbl1=new Label("Ingrese su correo electrónico");
        lbl1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        lbl2=new Label("Ingrese su contraseña");
        lbl2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        text1=new TextField();
        text1.setPrefWidth(20);
        text1.setPromptText("Ingrese su correo electrónico");
        text2=new PasswordField();
        text2.setPromptText("Ingrese su contraseña");
        text2.setPrefWidth(20);
        atras=new Button("Atrás");
        crearCuenta=new Button("Crear cuenta");
        hb.getChildren().addAll(crearCuenta,atras);
        hb.setAlignment(Pos.CENTER);
        hb1.getChildren().addAll(lbl);
        hb1.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        vb.getChildren().addAll(hb1,lbl1,text1,lbl2,text2,hb);
        vb.setAlignment(Pos.CENTER_LEFT);
        vb.setSpacing(5);
        bp.setCenter(vb);
        bp.setPadding(new Insets(30, 30, 30, 30));
        fm=new FileManagement();
        

    }
    
    private void crearUsuario(){
        if(text1.getText().equals("")==false && text2.getText().equals("")==false && fm.readFileUsuarios(Constant.USUARIOS_TXT,text1.getText(), text2.getText(),true)==false){
            String linea=text1.getText()+"|"+text2.getText();
            fm.writeFileUsuarios(Constant.USUARIOS_TXT, linea);
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Creación de cuenta existosa.");
            alert.showAndWait();
            text1.setText("");
            text2.setText("");
            Aplicacion.setUpAutenticacionWindow();
            
            
        }
        else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("El correo electrónico que intenta ingresar no es válido o ya existe.");
            alert.showAndWait();
            text1.setText("");
            text2.setText("");
            
        }
    }
    
    
    
    private void styleForBtn(){
        atras.setStyle(Constant.BUTTON_STYLE);
        crearCuenta.setStyle(Constant.BUTTON_STYLE);  
    }
    
    private void setUpActions(){
        crearCuenta.setOnAction(new ButtonHandler());
        atras.setOnAction(new ButtonHandler());
    }
    
    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(event.getSource()==crearCuenta){
                crearUsuario();
            }
            else if(event.getSource()==atras){
                Aplicacion.setUpAutenticacionWindow();
                
        }
        }   
    }
    
    public Pane getRoot(){
        return bp;
    }
}
