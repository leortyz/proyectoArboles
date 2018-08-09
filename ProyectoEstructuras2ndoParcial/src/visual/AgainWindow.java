/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.Aplicacion;
import constant.Constant;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author RODRIGUEZ
 */
public class AgainWindow {

    private BorderPane bp;
    private VBox vb;
    private HBox hb;
    private Label tittle;
    private Label guardar;
    private Button si;
    private Button no;

    public AgainWindow() {
        bp = new BorderPane();
        setUpScenario();
        setUpButtons();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER40);
    }

    private void setUpScenario() {
        guardar = new Label("La informacion ha sido guardada");
        guardar.setTextFill(Color.WHITE);
        guardar.setFont(new Font("Times New Roman", 30));
        tittle = new Label("¿Quiere volver a jugar?");
        tittle.setFont(new Font("Times New Roman", 26));
        si = new Button("SI");
        no = new Button("NO");
        hb = new HBox();
        hb.getChildren().addAll(si, no);
        hb.setSpacing(20);
        hb.setAlignment(Pos.CENTER);
        vb = new VBox();
        vb.getChildren().addAll(guardar, tittle, hb);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);
        bp.setCenter(vb);
        bp.setPadding(new Insets(20, 20, 20, 20));
        //Aplicacion.setBackground(bp,constant.Constant.WALLPAPER0);
    }

    private void setUpButtons() {
        si.setStyle(Constant.BUTTON_STYLE2);
        si.setMaxSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
        no.setStyle(Constant.BUTTON_STYLE2);
        no.setMaxSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
        si.setOnAction(new ButtonHandler());
        no.setOnAction(new ButtonHandler());
    }

    public class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == si) {
                Aplicacion.setUpGameWindow();
            } else if (event.getSource() == no) {
                Aplicacion.setUpMenuPrincipal();
            }
        }

    }

    public Pane getRoot() {
        return bp;
    }

}
