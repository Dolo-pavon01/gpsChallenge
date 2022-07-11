package edu.fiuba.algo3.Controlador;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


public class ControladorSonido{

    MediaPlayer mediaPlayer;
    MediaPlayer finish;

    public void playHitSound(String path){

        Media media = new Media(new File(path).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
        this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.mediaPlayer.setVolume(0.20);
        this.mediaPlayer.play();

    }
    public void playFinish(String path){

        Media media = new Media(new File(path).toURI().toString());
        this.finish = new MediaPlayer(media);
        this.finish.setVolume(0.30);
        this.finish.play();
    }


}
