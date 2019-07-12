package br.edu.ifpb.pweb2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_avaliacao_evento")
public class Avaliacao_Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Evento evento;
	
	private int nota_avaliacao_evento;
	
	@OneToOne
	private User participante;

	public Avaliacao_Evento() {};

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public int getNota_avaliacao_evento() {
		return nota_avaliacao_evento;
	}

	public void setNota_avaliacao_evento(int nota_avaliacao_evento) {
		this.nota_avaliacao_evento = nota_avaliacao_evento;
	}

	public User getParticipante() {
		return participante;
	}

	public void setParticipante(User participante) {
		this.participante = participante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Avaliacao_Evento [id=" + id + ", evento=" + evento.getDescricao() + ", nota_avaliacao_evento=" + nota_avaliacao_evento
				+ ", participante=" + participante.getNome() + "]";
	}
	

}
