package edu.fiuba.algo3.Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    private  ArrayList<String> podio = new ArrayList<>();

    public ArrayList<String> actualizarPodio(String nickname, Integer puntaje){
        //Escribo el archivo
        try {
            FileWriter myWriter = new FileWriter("src/main/java/edu/fiuba/algo3/rankings.txt",true);
            myWriter.write(" Jugador: "+ nickname + " Puntaje: "+ puntaje+"\n");
            myWriter.close();
            System.out.println("Se abrió con Exito el archivo.");
        } catch (IOException e) {
            System.out.println("Ocurrió un erro al intentar el archivo.");
            e.printStackTrace();
        }

        //Leer el archivo
        System.out.println("Voy a comenzar a leer el archivo 'Rankings.txt'");
        int count = 0;
        try {
            File myObj = new File("src/main/java/edu/fiuba/algo3/rankings.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                this.podio.add(data);
                System.out.println(count);
                count+=1;

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }

        return this.podio;

    }

}


