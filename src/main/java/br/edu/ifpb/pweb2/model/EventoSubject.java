package br.edu.ifpb.pweb2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@MappedSuperclass
public abstract class EventoSubject  {
 
    public abstract void attach(VagasObserver observer);
    
    public abstract void detach(int indice);
    
    public abstract void setState(EventoSubject evento);
     
    public abstract void notifyObservers();
     
    public abstract Evento getState();
     


}
