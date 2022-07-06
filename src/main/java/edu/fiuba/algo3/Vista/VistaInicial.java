package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorOpciones;
import javafx.application.Application;
import javafx.stage.Stage;

public class VistaInicial  {
    /*
        implementa la vista inicial del juego,
        se gestionan las acciones mediante su controlador
    */
    private String nickName;
    private String tipoVehiculo;
    private Stage stage;

    public VistaInicial(Stage stage){

        this.stage = stage;

    }
    public void mostrarVistaInicial()  {
        /*
            inicializa la vista principal, se muestra al usuario las
            opciones disponibles, se guarda el nombre del usuario

            IMPORTANTE:
                Como se cuando el usuario lleno el campo del nombre???
                habria alguna forma de validar a la hora de apretar el boton de jugar
                y impedir que el usaurio continue y mostrar un mensaje si el campo nombre está vacio?
         */


        /*

        ButtonAuto.setOnAction(()->{
            this.tipoVehiculo = "Auto";
        });
        ButtonMoto.setOnAction(()->{
            this.tipoVehiculo = "Moto";
        });
        ButtonAuto4x4.setOnAction(()->{
            this.tipoVehiculo = "Auto4x4";
        });
        ButtonJugar.setOnAction(new ControladorOpciones(this.nickname,this.tipoVehiculo));

         */
    }






}
