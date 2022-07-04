package edu.fiuba.algo3;

import edu.fiuba.algo3.controllers.HandlerBotonVehiculo;
import edu.fiuba.algo3.controllers.HandlerMoverVehiculo;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.visuales.Etiqueta;
import edu.fiuba.algo3.visuales.VistaMapa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;


public class Juego extends Application {
    private Vehiculo vehiculo;
    private ImageView dibujoVehiculo;
    public String fileToStylesheetString (File stylesheetFile) {
        try {
            return stylesheetFile.toURI().toURL().toString();
        } catch ( MalformedURLException e ) {
            return null;
        }
    }
    public void start(Stage primaryStage) throws Exception {

        this.vehiculo = new Vehiculo();

        String stylesheet = fileToStylesheetString( new File("src/main/java/edu/fiuba/algo3/estilos.css") );

        Text titulo = new Text("¡Bienvenido a GPS Challenge!");
        titulo.setId("titulo");

        Text elija = new Text("Elija su vehículo");
        elija.setId("elija");

        Button btnJugar = new Button();
        btnJugar.setText("JUGAR");
        btnJugar.setId("btnJugar");

        TextField nombreInput = new TextField();
        nombreInput.setPromptText("NOMBRE DEL JUGADOR");
        nombreInput.setId("nombreInput");

        Button motoBtn = new Button();
        motoBtn.setText("Moto");
        motoBtn.getStyleClass().add("botones");

        Button autoBtn = new Button();
        autoBtn.setText("Auto");
        autoBtn.getStyleClass().add("botones");

        Button auto4x4Btn = new Button();
        auto4x4Btn.setText("Auto 4x4");
        auto4x4Btn.getStyleClass().add("botones");

        HBox divBotones = new HBox(motoBtn, autoBtn, auto4x4Btn);
        divBotones.setId("divBotones");

        VBox divContenedor = new VBox(nombreInput, divBotones);
        divContenedor.setId("divContenedor");

        Group grupo = new Group (titulo, elija, btnJugar, divContenedor);

        Scene escena = new Scene(grupo, 700, 500);
        escena.getStylesheets().add(stylesheet);

        primaryStage.setTitle("Menú Inicial");
        primaryStage.setScene(escena);
        primaryStage.show();

        this.dibujoVehiculo = new ImageView();
        this.dibujoVehiculo.setY(300);
        this.dibujoVehiculo.setPreserveRatio(true);
        this.dibujoVehiculo.setFitHeight(50);

        autoBtn.setOnAction(new HandlerBotonVehiculo(this.vehiculo,this.dibujoVehiculo,new Auto(),"Auto"));
        motoBtn.setOnAction(new HandlerBotonVehiculo(this.vehiculo,this.dibujoVehiculo,new Moto(),"Moto"));
        auto4x4Btn.setOnAction(new HandlerBotonVehiculo(this.vehiculo,this.dibujoVehiculo,new Auto4x4(),"Auto4x4"));

        Label nombreJugador = new Label();
        nombreJugador.setLayoutX(200);
        nombreJugador.setLayoutY(200);
        new Etiqueta().aplicarDefault(nombreJugador);

        Label displayPuntaje = new Etiqueta().crearEtiqueta("Puntaje : 0",200,300);
        Label displayPosicion = new Etiqueta().crearEtiqueta("Posicion Actual: 0,1",200,400);

        VistaMapa vistaMapa = new VistaMapa();
        Gameplay gameplay = new Gameplay(new MapaFactory((int) vistaMapa.callesEnY, (int) vistaMapa.callesEnX));
        gameplay.iniciarJuego(vehiculo);
        Group group = new Group(vistaMapa.crearMapa(gameplay.getMapa()),nombreJugador,displayPuntaje,displayPosicion,this.dibujoVehiculo);
        Scene juego = new Scene(group,500,500, Color.BLACK);

        Label finDeJuego = new Label();
        finDeJuego.setTextFill(Color.WHITESMOKE);
        Group fin = new Group(finDeJuego);
        Scene pantallaFinal = new Scene(fin,500,500, Color.BLACK);
        btnJugar.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent arg0) {
                nombreJugador.setText("Jugador: " + nombreInput.getText());
                primaryStage.setScene(juego);
            }
        });

        juego.setOnKeyPressed(KeyEvent->
        {
            new HandlerMoverVehiculo(gameplay,dibujoVehiculo, KeyEvent.getCode(),vistaMapa.largoMovimiento);
            displayPuntaje.setText("Puntaje: " + gameplay.puntaje());
            displayPosicion.setText("Posicion Actual: " + gameplay.posicionJugador());
            if(gameplay.llegoAMeta())
            {
                finDeJuego.setText("TERMINASTE EL JUEGO " + nombreJugador.getText() + " CON UN PUNTAJE DE  " + displayPuntaje.getText());
                primaryStage.setScene(pantallaFinal);
            }
        });
    }
    public static void main (String[] args)
    {
        launch(args);
    }
}
