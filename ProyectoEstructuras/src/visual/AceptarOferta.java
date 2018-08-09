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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.Aplicacion;
import vehicle.Oferta;

/**
 *
 * @author RODRIGUEZ
 */
public class AceptarOferta {
    
    private BorderPane bp;
    private GridPane grid;
    private static VBox vb;
    private Label placa;
    private Label correo;
    private Label preciOf;
    private Label placaShow;
    private Label correoShow;
    private Label preciOfShow;
    private Label vehPlaca;
    private TextField vPlaca;
    private Button buscar;
    private Button ofAnterior;
    private Button siguiente;
    private Button aceptarOf;
    private Button regresar;
    private FileManagement fm;
    private Node<Oferta> nodo=null;
    private Oferta ofertaGuia;
    
    
    public AceptarOferta(){
        bp=new BorderPane();
        setUpPane();
        setUpButtons();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER);
        
    }
    
    public void setUpPane(){
        fm=new FileManagement();
        grid=new GridPane();
        vehPlaca=new Label("Ingrese placa: ");
        placa=new Label("PLACA");
        correo=new Label("CORREO");
        preciOf=new Label("PRECIO OFERTADO");
        placaShow=new Label();
        correoShow=new Label();
        preciOfShow=new Label();
        vPlaca=new TextField();
        buscar=new Button("Buscar Ofertas");
        ofAnterior=new Button("Oferta Anterior");
        siguiente=new Button("Siguiente Oferta");
        aceptarOf=new Button("Aceptar Oferta");
        regresar=new Button("Regresar");
        grid.addRow(0, vehPlaca, vPlaca, buscar);
        grid.addRow(1, placa, correo, preciOf);
        grid.addRow(2, placaShow, correoShow, preciOfShow);
        grid.addRow(3, ofAnterior, siguiente, aceptarOf);
        grid.add(regresar,2, 4);
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        initiateVb();
        bp.setTop(grid);
        bp.setBottom(vb);
    }
    
    private static void initiateVb(){
        vb=new VBox();
    }
    
    public void setUpButtons(){
        buscar.setOnAction(new ButtonHandler());
        ofAnterior.setOnAction(new ButtonHandler());
        siguiente.setOnAction(new ButtonHandler());
        aceptarOf.setOnAction(new ButtonHandler());
        regresar.setOnAction(new ButtonHandler());
        buscar.setStyle(constant.Constant.BUTTON_STYLE);
        ofAnterior.setStyle(constant.Constant.BUTTON_STYLE);
        siguiente.setStyle(constant.Constant.BUTTON_STYLE);
        aceptarOf.setStyle(constant.Constant.BUTTON_STYLE);
        regresar.setStyle(constant.Constant.BUTTON_STYLE);
    }

    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            LinkedList<Oferta> lista;
            LinkedList<Oferta> ofertas=new LinkedList<>();
            if (event.getSource()==buscar){
                String placa=vPlaca.getText();
                if("".equals(placa)){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Casillero vacío");
                    alert.setContentText("Ingrese una placa a buscar");
                    alert.showAndWait();
                }else{
                    lista=fm.readFile3("/files/ofertas.txt");
                    if(lista.size()>0){
                        Node<Oferta> p=lista.getFirst();
                        do{
                            Oferta of=p.getData();
                            if(of.getPlaca().equals(placa)){
                                ofertas.addLast(of);
                            }
                            p=p.getNext();
                        }while(p!=lista.getFirst());
                        if(!ofertas.isEmpty()){
                            nodo=ofertas.getFirst();
                            Oferta o=nodo.getData();
                            placaShow.setText(o.getPlaca());
                            correoShow.setText(o.getCorreo());
                            preciOfShow.setText(String.valueOf(o.getPrecioOfertado()));
                        }else{
                            Alert alert=new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("INFORMACIÓN");
                            alert.setHeaderText("No se han encontrado ofertas para dicho vehiculo");
                            alert.setContentText("Ingrese una nueva placa a buscar");
                            vPlaca.setText("");
                            alert.showAndWait();
                        }
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
                    alert.setHeaderText("No hay placa");
                    alert.setContentText("Ingrese una placa para buscar ofertas");
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
                    alert.setHeaderText("No hay placa");
                    alert.setContentText("Ingrese una placa para buscar ofertas");
                    alert.showAndWait();
                }
            }
            else if(event.getSource()==aceptarOf){
                if(!placaShow.getText().equals("")){
                    fm.eliminarLinea("/files/ofertas.txt", placaShow.getText());
                    fm.eliminarLinea("/files/autos.txt", placaShow.getText());
                    vPlaca.setText("");
                    placaShow.setText("");
                    correoShow.setText("");
                    preciOfShow.setText("");
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMACIÓN");
                    alert.setHeaderText(null);
                    alert.setContentText("Oferta aceptada exitosamente");
                    alert.showAndWait();
                    Aplicacion.setUpVendendorWindow();
                }else{
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("No hay placa");
                    alert.setContentText("Ingrese una placa para buscar ofertas");
                    alert.showAndWait();
                }
            }
            else if(event.getSource()==regresar){
                Aplicacion.setUpVendendorWindow();
            }
        }   
    }
    
    public Pane getRoot(){
        return bp;
    }
    
}
