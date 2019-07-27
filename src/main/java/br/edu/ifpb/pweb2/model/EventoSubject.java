package br.edu.ifpb.pweb2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class EventoSubject  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "evento",targetEntity = EventoSubject.class, cascade = CascadeType.ALL)
    private List<VagasObserver> observers;
    @OneToOne
    protected Evento evento;
 
    public EventoSubject() {
        observers = new ArrayList<VagasObserver>();
    }
 
    public void attach(VagasObserver observer) {
        observers.add(observer);
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
