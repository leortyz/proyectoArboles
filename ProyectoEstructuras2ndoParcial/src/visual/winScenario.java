/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import constant.Constant;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class winScenario {

    private BorderPane bp;
    private VBox vb;
    private HBox hb;
    private Label label;
    private Label win;
    private Button yes;
    private Button no;

    public winScenario() {
        setUpWindow();
        styleForBtn();
        setUpActions();
        setUpLabels();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER6);

    }

    private void setUpWindow() {
        vb = new VBox();
        bp = new BorderPane();
        hb = new HBox();
        win = new Label("¡HE ADIVINADO!");
        label = new Label("¿Deseas jugar de nuevo?");
        yes = new Button("Si");
        no = new Button("No");
        hb.getChildren().addAll(yes, no);
        vb.getChildren().addAll(win, label, hb);
        vb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        vb.setSpacing(25);
        hb.setAlignment(Pos.CENTER);
        bp.setCenter(vb);

    }

    private void setUpLabels() {
        win.setTextFill(Color.WHITE);
        label.setTextFill(Color.WHITE);
        win.setFont(new Font("Times New Roman", 30));
        label.setFont(new Font("Times New Roman", 20));
    }

    private void setUpActions() {
        yes.setOnAction(new ButtonHandler());
        no.setOnAction(new ButtonHandler());
    }

    public class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == yes) {
                Aplicacion.setUpGameWindow();
            } else if (event.getSource() == no) {
                Aplicacion.setUpMenuPrincipal();
            }
        }
    }

    private void styleForBtn() {
        yes.setStyle(Constant.BUTTON_STYLE2);
        no.setStyle(Constant.BUTTON_STYLE2);
        yes.setMaxSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
        no.setMaxSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
    }

    public Pane getRoot() {
        return bp;
    }
}
