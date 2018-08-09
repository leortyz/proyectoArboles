/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import constant.Constant;
import javafx.scene.control.Button;

/**
 *
 * @author EduardOrtiz
 */
public class EventsButton {
    void minusBoton(Button b) {
        b.setPrefSize(Constant.WIDTH_BUTTON - 10, Constant.HEIGH_BUTTON);
        }
    void plusBoton(Button b) {
            b.setPrefSize(Constant.WIDTH_BUTTON, Constant.HEIGH_BUTTON);
    }
}
