package br.edu.ifpb.pweb2.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public abstract class VagasObserver {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	protected EventoSubject evento;
	
	public VagasObserver() {}
	 
    public VagasObserver(EventoSubject evento) {
        this.evento= evento;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
 
    public abstract void update();

}
