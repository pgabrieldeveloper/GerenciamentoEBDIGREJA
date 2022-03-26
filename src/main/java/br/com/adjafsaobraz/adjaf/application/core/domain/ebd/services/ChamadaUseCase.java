package br.com.adjafsaobraz.adjaf.application.core.domain.ebd.services;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Chamada;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.in.ChamadaPortIn;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out.ChamadaPortOut;

import java.util.List;

public class ChamadaUseCase  implements ChamadaPortIn {

    private final ChamadaPortOut service;

    public ChamadaUseCase(ChamadaPortOut service) {
        this.service = service;
    }

    @Override
    public List<Chamada> realizarChamada(List<Chamada> chamada) {
        return service.realizarChamada(chamada);
    }
}
