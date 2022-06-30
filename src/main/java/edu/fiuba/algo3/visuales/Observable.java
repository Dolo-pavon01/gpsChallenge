package edu.fiuba.algo3.visuales;

public interface Observable {



        void addObserver(Observer observer);

        void notifyObservers();

}
