package br.edu.ifpb.pweb2.model;

public class MudaEstado implements MudarEstadoStrategy {

	@Override
	public void setState(boolean isempresa, State state, CandidatoVaga candidato ) {
			if(state.equals("DEFERIDO")) {
				candidato.setState(alterarAprovado(isempresa));
			}else if(state.equals("NAO_DEFERIDO")) {			   
				candidato.setState(alterarNaoAprovado(isempresa));
			}else {
				candidato.setState(State.NAO_AVALIADO);
			}
		} 
	public State alterarAprovado(boolean isempresa) {
		if(!isempresa) {
			return State.APROVADO;
		}
		return State.CONTRATADO;
	}
	
	public State alterarNaoAprovado(boolean isempresa) {
		if(!isempresa) {
			return State.NAO_APROVADO;
		}
		return State.NAO_CONTRATADO;
	}
	
	public State alterarNaoAvaliado() {
		return State.NAO_AVALIADO;
	}

	
}
