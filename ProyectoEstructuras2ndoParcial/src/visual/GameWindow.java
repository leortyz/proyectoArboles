/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import arbol.ArbolBinario;
import arbol.NodoAB;
import constant.Constant;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Aplicacion;
import pila.StackLinked;
import static visual.MenuPrincipal.backsound;

/**
 *
 * @author Fernando
 */
public class GameWindow {

    private BorderPane bp;
    private VBox vb;
    private HBox hb;
    private HBox hb1;
    private Label display;
    private FileManagement fm;
    private Button yes;
    private Button no;
    private Button regresar;
    protected static NodoAB<String> nodo;
    protected static ArbolBinario<String> arbol;

    public GameWindow() {
        setUp();
        styleForBtn();
        setUpActions();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER2);
    }

    private void setUp() {
        setUpStaticInNull();
        bp = new BorderPane();
        fm = new FileManagement();
        vb = new VBox();
        hb = new HBox();
        hb1 = new HBox();
        yes = new Button("Si");
        no = new Button("No");
        regresar = new Button("Volver al menú");
        hb.getChildren().addAll(yes, no);
        StackLinked<NodoAB<String>> pila = fm.cargarPila(Constant.DATOS_TXT);
        setUpStatic(pila,fm);
        String info = nodo.getData().substring(3);
        info = info.substring(0, 1).toUpperCase() + info.substring(1);
        display = new Label(info);
        display.setTextFill(Color.WHITE);
        display.setFont(new Font("Times New Roman", 20));
        vb.getChildren().addAll(display, hb);
        vb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        vb.setSpacing(25);
        hb.setAlignment(Pos.CENTER);
        bp.setCenter(vb);
        hb1.getChildren().addAll(regresar);
        hb1.setAlignment(Pos.CENTER);
        bp.setBottom(hb1);
        bp.setPadding(new Insets(20, 20, 20, 20));

    }
    
    private static void setUpStaticInNull(){
        arbol = null;
        nodo = null;
    }
    
    private static void setUpStatic(StackLinked<NodoAB<String>> pila,FileManagement fm){
        arbol = fm.cargarArbol(pila);
        nodo = arbol.getRaiz();
    }
    
   

    private void changeNodoIzq(NodoAB<String> nodo) {
        nodo = nodo.getIzq();
        String info = nodo.getData().substring(3);
        String id = nodo.getData().substring(0, 2);

        if (id.equals("#R")) {
            info = "¿Es " + info + "?";
            display.setText(info);
            setUpNodo(nodo);
        } else {
            info = info.substring(0, 1).toUpperCase() + info.substring(1);
            display.setText(info);
            setUpNodo(nodo);
        }

    }

    private void changeNodoDer(NodoAB<String> nodo) {
        nodo = nodo.getDer();
        String info = nodo.getData().substring(3);
        String id = nodo.getData().substring(0, 2);
        if (id.equals("#R")) {
            info = "¿Es " + info + "?";
            display.setText(info);
            setUpNodo(nodo);
        } else {
            info = info.substring(0, 1).toUpperCase() + info.substring(1);
            display.setText(info);
            setUpNodo(nodo);
        }

    }
    
    private static void setUpNodo(NodoAB<String> nodo){
        GameWindow.nodo = nodo;
    }

    private void setUpActions() {
        yes.setOnAction(new ButtonHandler());
        no.setOnAction(new ButtonHandler());
        regresar.setOnAction(new ButtonHandler());
    }

    public class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == yes) {
                if (nodo.getIzq() != null) {
                    changeNodoIzq(nodo);
                } else {
                    Aplicacion.setUpWinScenario();

                }
            } else if (event.getSource() == no) {
                if (nodo.getDer() != null) {
                    changeNodoDer(nodo);
                } else {
                    Aplicacion.setUpLoseScenario();

                }
            } else if (event.getSource() == regresar) {
                Aplicacion.setUpMenuPrincipal();
            }

        }
    }

    private void styleForBtn() {
        yes.setStyle(Constant.BUTTON_STYLE2);
        no.setStyle(Constant.BUTTON_STYLE2);
        yes.setMaxSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
        no.setMaxSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
        regresar.setStyle(Constant.BUTTON_STYLE2);
        regresar.setMaxSize(150, Constant.HEIGH_BUTTON);
    }
    
    

    public Pane getRoot() {
        return bp;
    }

}
