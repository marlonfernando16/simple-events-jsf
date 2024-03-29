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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vaga")
public class Vaga extends VagasObserver {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	public Vaga() {
	}

	@ManyToOne(fetch = FetchType.EAGER)
	protected Evento evento;

	private int qtd_vagas;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "vaga", cascade = CascadeType.ALL)
	private List<CandidatoVaga> candidato_vaga = new ArrayList<>();

	@OneToOne
	private Especialidade especialidade;

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public int getQtd_vagas() {
		return qtd_vagas;
	}

	public void setQtd_vagas(int qtd_vagas) {
		this.qtd_vagas = qtd_vagas;
	}

	public void add(int i, CandidatoVaga candidato) {
		this.candidato_vaga.add(i, candidato);
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Vaga [id=" + id + ", evento=" + ", qtd_vagas=" + qtd_vagas + ", especialidade="
				+ especialidade.getNome() + "]";
	}

	@Override
	public void update(EventoSubject evento) {
		for (CandidatoVaga cv : this.getCandidato_vaga()) {
			cv.getCandidato().addNotify("O evento " + evento.getState().getNome() + " foi finalizado !");
		}

	}

	public Evento getEvento() {
		return evento;
	}

	@Override
	public void setEvento(Evento evento) {
		this.evento = evento;

	}

	public List<CandidatoVaga> getCandidato_vaga() {
		return candidato_vaga;
	}

	public void setCandidato_vaga(List<CandidatoVaga> candidato_vaga) {
		this.candidato_vaga = candidato_vaga;
	}

}
