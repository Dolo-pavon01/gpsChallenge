package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.HandlerBotonVehiculo;
import edu.fiuba.algo3.Controlador.HandlerMoverVehiculo;
import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Vista.MapaBase;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Locale;


public class Juego extends Application {
    private  TextField nombreInput = new TextField();
    private Vehiculo vehiculo;
    private ImageView dibujoVehiculo;
    private Button  autoBtn = new Button();
    private Button  motoBtn = new Button();
    private Button auto4x4Btn = new Button();
    private Button BtnJugar = new Button();
    private String vehiculoEnJuego = new String();
    private MapaBase mapa;
    private Stage primaryStage;
    private Integer dimension;

    public String fileToStylesheetString (File stylesheetFile) {
        try {
            return stylesheetFile.toURI().toURL().toString();
        } catch ( MalformedURLException e ) {
            return null;
        }
    }

    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        String stylesheet = fileToStylesheetString(new File("src/main/java/edu/fiuba/algo3/Vista/estilos.css"));

        Text titulo = new Text("¡Bienvenido a GPS Challenge!");
        titulo.setId("titulo");

        Text elija = new Text("Elija su vehículo");
        elija.setId("elija");


        this.BtnJugar.setText("JUGAR");
        this.BtnJugar.setId("btnJugar");
        this.nombreInput.setPromptText("NOMBRE DEL JUGADOR");
        this.nombreInput.setId("nombreInput");

        this.motoBtn.setText("Moto");
        this.motoBtn.getStyleClass().add("botones");

        this.autoBtn.setText("Auto");
        this.autoBtn.getStyleClass().add("botones");

        this.auto4x4Btn.setText("Auto 4x4");
        this.auto4x4Btn.getStyleClass().add("botones");

        HBox divBotones = new HBox(motoBtn, autoBtn, auto4x4Btn);
        divBotones.setId("divBotones");

        VBox divContenedor = new VBox(this.nombreInput, divBotones);
        divContenedor.setId("divContenedor");

        Group grupo = new Group(titulo, elija, BtnJugar, divContenedor);

        Scene escena = new Scene(grupo, 700, 500);
        escena.getStylesheets().add(stylesheet);

        primaryStage.setTitle("Menú Inicial");
        primaryStage.setScene(escena);
        primaryStage.show();

    }
    public String getNombreDeUsuario() {
        return this.nombreInput.getText();
    }



    public String preguntarVehiculo() {

        this.dibujoVehiculo = new ImageView();
        this.dibujoVehiculo.setY(300);
        this.dibujoVehiculo.setPreserveRatio(true);
        this.dibujoVehiculo.setFitHeight(50);

        this.autoBtn.setOnAction(event -> {
            this.vehiculoEnJuego = "Auto";
        });
        this.motoBtn.setOnAction(event -> {
            this.vehiculoEnJuego = "Moto";
        });
        this.auto4x4Btn.setOnAction(event -> {
            this.vehiculoEnJuego = "Auto4X4";
        });

        BtnJugar.setOnAction(event -> {
            this.mapa = new MapaBase();
        });

        return this.vehiculoEnJuego;
    }
    public void jugar(HandlerMoverVehiculo movimientosHandle) throws Exception {

        MapaBase mapaVista = new MapaBase();
        Group entidades = mapaVista.crearMapaBase(this.dimension);
        mapaVista.dibujarVehiculo(this.vehiculoEnJuego);

        Scene juego = new Scene(entidades,500,500, Color.BLACK);

        Label finDeJuego = new Label();
        finDeJuego.setTextFill(Color.WHITESMOKE);
        Group fin = new Group(finDeJuego);
        Scene pantallaFinal = new Scene(fin,500,500, Color.BLACK);

        juego.setOnKeyPressed(KeyEvent->
        {
            KeyCode code = KeyEvent.getCode();
            movimientosHandle.movimientoHacia((code.toString()).toLowerCase().charAt(0));

            if(movimientosHandle.terminarEjecuccion())
            {
                finDeJuego.setText("TERMINASTE EL JUEGO ");
                this.primaryStage.setScene(pantallaFinal);
            }
        });
    }
    public void setDimension(int dimension){
        this.dimension = dimension;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
