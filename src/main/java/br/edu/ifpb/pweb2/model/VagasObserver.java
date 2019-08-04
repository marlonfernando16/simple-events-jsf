package br.edu.ifpb.pweb2.model;

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
@MappedSuperclass
public abstract class VagasObserver {	

    
    
 
    public abstract EventoSubject getEvento();



	public abstract void setEvento(Evento evento);



	public abstract void update();

	
	public VagasObserver() {}
	 
    

	

}
