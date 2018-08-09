/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import LinkedList.LinkedList;
import LinkedList.Node;
import fileManagement.FileManagement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import main.Aplicacion;
import vehicle.Oferta;

/**
 *
 * @author Fernando
 */
public class EliminarOferta {
    private BorderPane bp;
    private GridPane grid;
    private Label correoUsuario;
    private Label placa;
    private Label correo;
    private Label preciOf;
    private Label placaShow;
    private Label correoShow;
    private Label preciOfShow;
    private Button buscar;
    private Button ofAnterior;
    private Button siguiente;
    private Button eliminarOf;
    private Button regresar;
    FileManagement fm;
    private Node<Oferta> nodo;
    
    public EliminarOferta(){
        bp=new BorderPane();
        setUpPane();
        setUpButtons();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER);
    }
    
    public void setUpPane(){
        fm=new FileManagement();
        grid=new GridPane();
        placa=new Label("PLACA");
        correo=new Label("CORREO");
        preciOf=new Label("PRECIO OFERTADO");
        correoUsuario=new Label("Correo electrónico: "+AutenticacionUsuarios.correo);
        placaShow=new Label();
        correoShow=new Label();
        preciOfShow=new Label();
        buscar=new Button("Buscar Ofertas");
        ofAnterior=new Button("Oferta Anterior");
        siguiente=new Button("Siguiente Oferta");
        eliminarOf=new Button("Eliminar Oferta");
        regresar=new Button("Regresar");
        grid.addRow(0, correoUsuario, buscar);
        grid.addRow(1, placa, correo, preciOf);
        grid.addRow(2, placaShow, correoShow, preciOfShow);
        grid.addRow(3, ofAnterior, siguiente, eliminarOf);
        grid.add(regresar,2, 4);
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        bp.setCenter(grid);
    }
    
    public void setUpButtons(){
        buscar.setOnAction(new ButtonHandler());
        ofAnterior.setOnAction(new ButtonHandler());
        siguiente.setOnAction(new ButtonHandler());
        eliminarOf.setOnAction(new ButtonHandler());
        regresar.setOnAction(new ButtonHandler());
        buscar.setStyle(constant.Constant.BUTTON_STYLE);
        ofAnterior.setStyle(constant.Constant.BUTTON_STYLE);
        siguiente.setStyle(constant.Constant.BUTTON_STYLE);
        eliminarOf.setStyle(constant.Constant.BUTTON_STYLE);
        regresar.setStyle(constant.Constant.BUTTON_STYLE);
    }
    
    private void ofertasUsuario(){
        LinkedList<Oferta> lista;
        LinkedList<Oferta> ofertas=new LinkedList<>();
        lista=fm.readFile3("/files/ofertas.txt");
        if(lista.size()>0){
            Node<Oferta> p=lista.getFirst();
            do{
                Oferta of=p.getData();
                if(of.getCorreo().equals(AutenticacionUsuarios.correo)){
                    ofertas.addLast(of);
                }
                p=p.getNext();
            }while(p!=lista.getFirst());
            if(!ofertas.isEmpty()){
                nodo=ofertas.getFirst();
                Oferta o=nodo.getData();
                System.out.println(nodo.getData().getPlaca());
                placaShow.setText(o.getPlaca());
                correoShow.setText(o.getCorreo());
                preciOfShow.setText(String.valueOf(o.getPrecioOfertado()));
            }else{
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMACIÓN");
                //alert.setHeaderText("No se han encontrado ofertas para dicho vehiculo");
                alert.setContentText("No se han encontrado ofertas bajo su correo.");
                alert.showAndWait();
            }
         }
        
     }   
        
    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(event.getSource()==buscar){
               LinkedList<Oferta> lista;
               LinkedList<Oferta> ofertas=new LinkedList<>();
               lista=fm.readFile3("/files/ofertas.txt");
               if(lista.size()>0){
               Node<Oferta> p=lista.getFirst();
               do{
                   Oferta of=p.getData();
                   if(of.getCorreo().equals(AutenticacionUsuarios.correo)){
                       ofertas.addLast(of);
                }
                   p=p.getNext();
               }while(p!=lista.getFirst());
               if(!ofertas.isEmpty()){
                   nodo=ofertas.getFirst();
                   Oferta o=nodo.getData();
                   System.out.println(nodo.getData().getPlaca());
                   placaShow.setText(o.getPlaca());
                   correoShow.setText(o.getCorreo());
                   preciOfShow.setText(String.valueOf(o.getPrecioOfertado()));
                   
                   
               }else{
                   Alert alert=new Alert(Alert.AlertType.INFORMATION);
                   alert.setTitle("INFORMACIÓN");
                   //alert.setHeaderText("No se han encontrado ofertas para dicho vehiculo");
                   alert.setContentText("No se han encontrado ofertas bajo su correo.");
                   alert.showAndWait();
                }
            }
               
            }
            
            else if(event.getSource()==ofAnterior){
                if(!placaShow.getText().equals("")){
                    if(nodo.getPrevious()!=null){
                        nodo=nodo.getPrevious();
                        Oferta o=nodo.getData();
                        placaShow.setText(o.getPlaca());
                        correoShow.setText(o.getCorreo());
                        preciOfShow.setText(String.valueOf(o.getPrecioOfertado()));
                    } 
                }else{
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("No hay ofertas");
                    alert.setContentText("No se han encontrado ofertas");
                    alert.showAndWait();
                }
            }
            else if(event.getSource()==siguiente){
                if(!placaShow.getText().equals("")){
                    if(nodo.getNext()!=null){
                        nodo=nodo.getNext();
                        Oferta o=nodo.getData();
                        placaShow.setText(o.getPlaca());
                        correoShow.setText(o.getCorreo());
                        preciOfShow.setText(String.valueOf(o.getPrecioOfertado()));
                    }
                }else{
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("No hay ofertas");
                    alert.setContentText("No se han encontrado ofertas");
                    alert.showAndWait();
                }
            }
            else if(event.getSource()==eliminarOf){
                if(!placaShow.getText().equals("")){
                    fm.eliminarLineaOfertas("/files/ofertas.txt", placaShow.getText(),correoShow.getText(),preciOfShow.getText());
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMACIÓN");
                    //alert.setHeaderText("No se han encontrado ofertas para dicho vehiculo");
                    alert.setContentText("La oferta realizada al vehículo"+placaShow.getText()+" de monto"+preciOfShow.getText()+" ha sido eliminada.");
                    alert.showAndWait();
                    placaShow.setText("");
                    correoShow.setText("");
                    preciOfShow.setText("");
                    nodo=null;
                    Aplicacion.setUpCompradorWindow();
                }else{
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("No hay ofertas");
                    alert.setContentText("No se han encontrado ofertas");
                    alert.showAndWait();
                }
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
