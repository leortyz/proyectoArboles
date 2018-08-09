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
public class AutenticacionUsuarios {
    private VBox vb;
    private BorderPane bp;
    private HBox hb;
    private HBox hb1;
    private Button iniciar;
    private Button crearCuenta;
    private Label lbl;
    private Label lbl1;
    private Label lbl2;
    private TextField text1;
    private PasswordField text2;
    private FileManagement fm;
    static String correo;
    
    
    
    public AutenticacionUsuarios(){
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
        lbl=new Label("Ingreso de Usuarios");
        lbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        lbl1=new Label("Correo Electrónico");
        lbl1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        lbl2=new Label("Contraseña");
        lbl2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        text1=new TextField();
        text1.setPrefWidth(20);
        text1.setPromptText("Ingrese su correo electrónico");
        text2=new PasswordField();
        text2.setPromptText("Ingrese su contraseña");
        text2.setPrefWidth(20);
        iniciar=new Button("Iniciar sesión");
        crearCuenta=new Button("Crear cuenta");
        hb.getChildren().addAll(iniciar,crearCuenta);
        hb.setAlignment(Pos.CENTER);
        hb1.getChildren().addAll(lbl);
        hb1.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        vb.getChildren().addAll(hb1,lbl1,text1,lbl2,text2,hb);
        vb.setAlignment(Pos.CENTER_LEFT);
        vb.setSpacing(5);
        bp.setCenter(vb);
        bp.setPadding(new Insets(30, 30, 30, 30));
        

    }
    
    
    private void ingresarUsuario(){
        if(text1.getText().equals("")==false && text2.getText().equals("")==false && fm.readFileUsuarios(Constant.USUARIOS_TXT,text1.getText(), text2.getText(),false)){
            guardarCorreo(text1.getText());
            Aplicacion.setUpMenuWindow(); 
        }
        
        else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Su ingreso no fue exitoso.");
            alert.showAndWait();
            text1.setText("");
            text2.setText("");
            
        }
    }
    
    private static void guardarCorreo(String mail){
        correo=mail;
    }
    
    
    private void styleForBtn(){
        iniciar.setStyle(Constant.BUTTON_STYLE);
        crearCuenta.setStyle(Constant.BUTTON_STYLE);  
    }
    
    private void setUpActions(){
        iniciar.setOnAction(new ButtonHandler());
        crearCuenta.setOnAction(new ButtonHandler());
    }
    
    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(event.getSource()==iniciar){
                ingresarUsuario();
            }
            else if(event.getSource()==crearCuenta){
                Aplicacion.setUpCrearUsuario();
  
        }
        }   
    }
    
    public Pane getRoot(){
        return bp;
    }
    
}
