package edu.fiuba.algo3.Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
  private ArrayList<String> podio = new ArrayList<String>();

  public ArrayList<String> actualizarPodio(String nickname, Integer puntaje) {
    // Leer el archivo
    this.leer_archivo();
    this.podio.add("Jugador: " + nickname + " Puntaje: " + puntaje);
    // Escribo el archivo
    this.escribir_archivo();
    // Leer
    this.podio = new ArrayList<String>();
    this.leer_archivo();
    return this.podio;
  }

  private void leer_archivo() {
    System.out.println("Voy a comenzar a leer el archivo 'Rankings.txt'");
    try {
      File myObj = new File("src/main/java/edu/fiuba/algo3/rankings.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        // this.podio_viejo.add(data);
        this.podio.add(data.replaceAll("\\n", ""));
      }
      myReader.close();
    } catch (FileNotFoundException e) {
    }
  }

  private void escribir_archivo() {
    try {
      FileWriter myWriter = new FileWriter("src/main/java/edu/fiuba/algo3/rankings.txt");
      for (int i = 0; i < this.podio.size(); i++) {
        myWriter.write( this.podio.get(this.podio.size() - 1 - i) + "\n");
      }
      myWriter.close();
    } catch (IOException e) {
    }
  }
}
