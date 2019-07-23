package br.edu.ifpb.pweb2.model;

import java.util.ArrayList;

public class EventoSubject  {
    protected ArrayList<VagasObserver> observers;
    protected Evento evento;
 
    public EventoSubject() {
        observers = new ArrayList<VagasObserver>();
    }
 
    public void attach(VagasObserver observer) {
        observers.add(observer);
    }
 
    public void detach(int indice) {
        observers.remove(indice);
    }
    
    public void setState(Evento evento) {
        this.evento = evento;
        notifyObservers();
    }
     
    private void notifyObservers() {
        for (VagasObserver observer : observers) {
            observer.update();
        }
    }
     
    public Evento getState() {
        return evento;
    }

}
