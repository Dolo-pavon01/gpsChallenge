package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Gameplay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Rotate;

public class HandlerMoverVehiculo implements EventHandler<ActionEvent> {
    private Gameplay gameplay;
    private ImageView dibujoVehiculo;
    private char direccion;


    public HandlerMoverVehiculo(Gameplay gameplay, ImageView dibujoVehiculo, KeyCode code) {
        this.dibujoVehiculo = dibujoVehiculo;
        this.gameplay = gameplay;
        this.direccion = (code.toString()).toLowerCase().charAt(0);
        this.handle(new ActionEvent());

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.dibujoVehiculo.setRotationAxis(Rotate.Z_AXIS);
        if (this.gameplay.jugar(this.direccion)) {
            switch (this.direccion) {
                case 'd':
                    this.dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
                    this.dibujoVehiculo.setX(this.dibujoVehiculo.getX() + 50);
                    this.dibujoVehiculo.setRotate(0);
                    break;
                case 'a':

                    this.dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
                    this.dibujoVehiculo.setX(this.dibujoVehiculo.getX() - 50);
                    this.dibujoVehiculo.setRotate(180);
                    break;
                case 'w':

                    this.dibujoVehiculo.setY(this.dibujoVehiculo.getY() - 50);
                    this.dibujoVehiculo.setRotate(270);
                    break;
                case 's':

                    this.dibujoVehiculo.setY(this.dibujoVehiculo.getY() + 50);
                    this.dibujoVehiculo.setRotate(90);
                    break;
                default:
                    break;

            }

        }
    }

}
