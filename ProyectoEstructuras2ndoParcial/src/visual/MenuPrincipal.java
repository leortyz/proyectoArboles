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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import main.Aplicacion;

/**
 *
 * @author Fernando
 */
public class MenuPrincipal {

    private BorderPane bp;
    private VBox vb;
    private Button jugar;
    private Button salir;
    protected static AudioClip backsound;

    public MenuPrincipal() {
        //setBackgroundMusic();
        setUpWindow();
        styleForBtn();
        setUpActions();
        Aplicacion.setBackground(bp, constant.Constant.WALLPAPER8);

    }

    private void setUpWindow() {
        vb = new VBox();
        bp = new BorderPane();
        jugar = new Button("Jugar");
        salir = new Button("Salir");
        vb.getChildren().addAll(jugar, salir);
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);
        bp.setCenter(vb);

    }

    private void styleForBtn() {
        jugar.setStyle(Constant.BUTTON_STYLE2);
        salir.setStyle(Constant.BUTTON_STYLE2);
        jugar.setMaxSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
        salir.setMaxSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
    }

    private void setUpActions() {
        jugar.setOnAction(new ButtonHandler());
        salir.setOnAction(new ButtonHandler());
    }

    public class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == jugar) {
                Aplicacion.setUpDialogWindow();
            } else if (event.getSource() == salir) {
                Aplicacion.closeApp();
            }
        }
    }

    public Pane getRoot() {
        return bp;
    }

    /*void setBackgroundMusic() {
        backsound = new AudioClip(this.getClass().getResource("/images/fondo.mp3").toExternalForm());
        backsound.play();

    }*/
}
