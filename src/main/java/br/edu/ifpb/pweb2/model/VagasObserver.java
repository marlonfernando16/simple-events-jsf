package br.edu.ifpb.pweb2.model;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public abstract class VagasObserver {
	@ManyToOne(fetch=FetchType.EAGER)
	protected EventoSubject evento;
	 
    public VagasObserver(EventoSubject evento) {
        this.evento= evento;
    }
 
    public abstract void update();

}
