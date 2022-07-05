package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Modelo.Gameplay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.transform.Rotate;

public class HandlerMoverVehiculo implements EventHandler<ActionEvent> {
    private Gameplay gameplay;
    private ImageView dibujoVehiculo;
    private char direccion;

    private double longitudMovimiento;


    public HandlerMoverVehiculo(Gameplay gameplay) {
        this.gameplay = gameplay;

    }
    public void movimientoHacia(char movimiento){
        this.direccion = movimiento;

    }
    public boolean terminarEjecuccion(){
        return gameplay.llegoAMeta();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.dibujoVehiculo.setRotationAxis(Rotate.Z_AXIS);
        if (this.gameplay.jugar(this.direccion)) {
            switch (this.direccion) {
                case 'd':
                    this.dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
                    this.dibujoVehiculo.setX(this.dibujoVehiculo.getX() + this.longitudMovimiento);
                    this.dibujoVehiculo.setRotate(0);
                    break;
                case 'a':

                    this.dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
                    this.dibujoVehiculo.setX(this.dibujoVehiculo.getX() - this.longitudMovimiento);
                    this.dibujoVehiculo.setRotate(180);
                    break;
                case 'w':

                    this.dibujoVehiculo.setY(this.dibujoVehiculo.getY() - this.longitudMovimiento);
                    this.dibujoVehiculo.setRotate(270);
                    break;
                case 's':

                    this.dibujoVehiculo.setY(this.dibujoVehiculo.getY() + this.longitudMovimiento);
                    this.dibujoVehiculo.setRotate(90);
                    break;
                default:
                    break;

            }

        }
    }

}
