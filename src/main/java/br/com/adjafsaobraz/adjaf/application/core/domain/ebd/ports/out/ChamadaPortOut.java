package br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Chamada;

import java.util.List;

public interface ChamadaPortOut {
    List<Chamada> realizarChamada(List<Chamada> chamada);

}
