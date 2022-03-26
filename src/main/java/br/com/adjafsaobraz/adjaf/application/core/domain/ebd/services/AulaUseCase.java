package br.com.adjafsaobraz.adjaf.application.core.domain.ebd.services;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Aula;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.in.AulaPortIn;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out.AulaPortOut;

import java.util.List;

public class AulaUseCase implements AulaPortIn {

    private final AulaPortOut service;

    public AulaUseCase(AulaPortOut service) {
        this.service = service;
    }


    @Override
    public Aula cadastarAula(Aula aula) {
        return service.cadastarAula(aula);
    }

    @Override
    public List<Aula> pegaTodasAulas() {
        return service.pegaTodasAulas();
    }

    @Override
    public Aula PegarAulaPorId(Integer id) {
        return service.PegarAulaPorId(id);
    }

    @Override
    public void deletarAula(Integer id) {
        service.deletarAula(id);
    }


}
