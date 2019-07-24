package br.edu.ifpb.pweb2.model;

public class MudaEstadoIndeferido implements MudarEstadoStrategy {

	@Override
	public void setState(State state, Candidato_Vaga candidato) {
		if(state.equals("NAO_DEFERIDO")) {			   
			candidato.setState(State.NAO_APROVADO);
		}  
		
	}

}
