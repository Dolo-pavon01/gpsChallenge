package edu.fiuba.algo3;

import edu.fiuba.algo3.Vista.VistaFinal;
//import edu.fiuba.algo3.Vista.VistaInicial;
import edu.fiuba.algo3.Vista.VistaMapa;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppGpsChallenge extends Application {


    private  Stage primaryStage;

    public void start(Stage primaryStage) throws Exception {

        this.primaryStage= primaryStage;

        //VistaInicial vistaInicial = new VistaInicial(primaryStage);
        //vistaInicial.mostrarVistaInicial();
        VistaMapa vistaMapa = new VistaMapa(primaryStage);
        vistaMapa.mostrarVistaMapa(3);
        //VistaFinal vistaFinal  = new VistaFinal(primaryStage);
        //vistaFinal.mostrarVistaFinal();


    }

    public static void main(String[] args){

        launch(args);
    }
}
