package br.edu.ifpb.pweb2.model;

public class MudaEstadoDeferido implements MudarEstadoStrategy {

	@Override
	public void setState(State state, Candidato_Vaga candidato) {
		if(state.equals("DEFERIDO")) {
			candidato.setState(State.APROVADO);

	}
		
}

}
