package br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.in;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Chamada;

import java.util.List;

public interface ChamadaPortIn {

    List<Chamada> realizarChamada(List<Chamada> chamada);

}
