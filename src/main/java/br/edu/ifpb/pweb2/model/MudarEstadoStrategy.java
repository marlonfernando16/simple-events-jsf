package br.edu.ifpb.pweb2.model;

public interface MudarEstadoStrategy {
	public void setState(State state, Candidato_Vaga candidato);
}
