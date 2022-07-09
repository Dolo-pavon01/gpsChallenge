package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorVistaFinal;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaFinal  {
    /*
       Encargada de mostrar la vista final con:
            -Ranking
            -Nombre de Usuario Actual, sus movimientos generados y
            su posicion en el ranking
       Utiliza el controlador de vista final.
     */

    public ArrayList<String> informacion = new ArrayList<String>();
    private Stage stage;
    private ControladorVistaFinal controladorFinal = new ControladorVistaFinal();
    private ArrayList items = new ArrayList();
    private Group group = new Group();
    private ArrayList elements = new ArrayList<>();
    private Label labelScore = new Label("0");


    public VistaFinal(Stage stage){

        this.stage = stage;

    }
    public void mostrarVistaFinal(){

        /*
        Cuando llega a la meta se puede poner una opcion que diga
        "Click Aqui para ver los datos del juego"
        ButtonShowStatus.setOnAction(new ControladorVistaFinal(this.informacion));

        codigo para mostrar informacion

         */

        ArrayList<String> infoRankings = this.controladorFinal.getRankings();


        for(int i =0;i< infoRankings.size();i++){
            Text nombre = new Text(infoRankings.get(i));
            nombre.setX(200);
            nombre.setY(100+(i*25));
            this.elements.add(nombre);
            System.out.println(infoRankings.get(i));
        }
        Label jugador = new Label("Jugador");
        jugador.setStyle("-fx-font-size: 18;"  + "-fx-text-alignment: left");


        Label puntaje = new Label("Puntaje");
        puntaje.setStyle("-fx-font-size: 18;"  + "-fx-text-alignment: center");

        Label puesto = new Label("Puesto");
        puesto.setStyle("-fx-font-size: 18;"  + "-fx-text-alignment: right");



        Scene scene = new Scene(this.group,800,200, Color.AQUAMARINE);
        this.group.getChildren().addAll(this.elements);
        this.group.getChildren().add(jugador);
        this.group.getChildren().add(puntaje);
        this.group.getChildren().add(puesto);
        this.stage.setScene(scene);
        this.stage.show();






    }

}
