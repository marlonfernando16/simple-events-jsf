package br.edu.ifpb.pweb2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tb_evento")
public class Evento extends EventoSubject {
	

	@NotEmpty(message = "Descricao e obrigatoria")
	private String nome;
	
	@NotEmpty(message = "Descricao e obrigatoria")
	private String descricao;

//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data e obrigatoria")
	@Future(message = "A data deve estar no futuro")
	private Date data;
	
	@NotEmpty(message = "Local e obrigatorio")
	private String local;

	@ManyToOne
	private User owner;
	
	boolean finalizado;


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "evento", cascade = CascadeType.ALL)
	private List<Avaliacao_Evento> avaliacao_eventos = new ArrayList<>();

	public Evento() {};

	public Evento(String d, Date dh, String l) {
		super();
		this.descricao = d;
		this.data = dh;
		this.local = l;
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	public void setAvaliacao_eventos(List<Avaliacao_Evento> avaliacao_eventos) {
		this.avaliacao_eventos = avaliacao_eventos;
	}

	public List<Avaliacao_Evento> getAvaliacao_eventos() {
		return avaliacao_eventos;
	}

	

	public void setAvaliacao_eventos(ArrayList<Avaliacao_Evento> avaliacao_eventos) {
		this.avaliacao_eventos = avaliacao_eventos;
	}



	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}



	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date datahora) {
		this.data = datahora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return "Evento [id=" + super.getId() + ", descricao=" + descricao + ", data=" + data + ", local=" + local + ", owner="
				+ owner + ", vagas=" + ", avaliacao_eventos=" + avaliacao_eventos +"finalizado"+finalizado+"media"+getMediaAvaliacao()+ "]";
	}
	
	public double getMediaAvaliacao() {
		int sum = 0;
		for (Avaliacao_Evento av:  this.avaliacao_eventos) {
			sum += av.getNota_avaliacao_evento();
		}
		double media = sum / this.avaliacao_eventos.size();
		return (double) Math.round(media * 100) / 100;
	}

}
