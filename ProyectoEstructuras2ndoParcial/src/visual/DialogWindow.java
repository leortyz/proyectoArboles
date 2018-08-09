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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Aplicacion;

/**
 *
 * @author Fernando
 */
public class DialogWindow {

    private BorderPane bp;
    private VBox vb;
    private HBox hb;
    private Label line1;
    private Label line2;
    private Label line3;
    private Button next;
    private Button atras;

    public DialogWindow() {
        setUpWindow();
        styleForBtn();
        setUpActions();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER1);

    }

    private void setUpWindow() {
        vb = new VBox();
        bp = new BorderPane();
        hb = new HBox();
        next = new Button("Siguiente");

        atras = new Button("Atrás");
        line1 = new Label("¡Bienvenido a Genio Politécnico!");
        line1.setFont(new Font("Times New Roman", 30));
        line2 = new Label("Piense en un animal, que yo trataré de adivinarlo…");
        line2.setFont(new Font("Times New Roman", 20));
        line3 = new Label("¿Estás listo para presenciar mis poderes?");
        line3.setFont(new Font("Times New Roman", 20));
        vb.getChildren().addAll(line1, line2, line3);
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(atras, next);
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        bp.setLeft(vb);
        bp.setBottom(hb);
        bp.setPadding(new Insets(5, 5, 5, 5));
    }

    private void styleForBtn() {
        next.setStyle(Constant.BUTTON_STYLE2);
        atras.setStyle(Constant.BUTTON_STYLE2);
        next.setMaxSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
        atras.setMaxSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
    }

    private void setUpActions() {
        next.setOnAction(new ButtonHandler());
        atras.setOnAction(new ButtonHandler());
    }

    public class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == next) {
                Aplicacion.setUpGameWindow();
            } else if (event.getSource() == atras) {
                Aplicacion.setUpMenuPrincipal();
            }
        }
    }

    public Pane getRoot() {
        return bp;
    }
}
