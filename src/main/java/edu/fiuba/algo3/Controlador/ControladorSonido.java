package edu.fiuba.algo3.Controlador;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


public class ControladorSonido{

    MediaPlayer mediaPlayer;

    @FXML
    void play(MouseEvent event) {
        String fileName = "docs/sonido.mp3";
        playHitSound(fileName);
    }


    private void playHitSound(String fileName){
        String path = getClass().getResource(fileName).getPath();
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

}
