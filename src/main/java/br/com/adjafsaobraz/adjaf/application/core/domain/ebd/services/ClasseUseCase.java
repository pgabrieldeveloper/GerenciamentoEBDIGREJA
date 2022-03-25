package br.com.adjafsaobraz.adjaf.application.core.domain.ebd.services;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Classe;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.in.ClassePortIn;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out.ClassePortOut;

import java.util.List;

public class ClasseUseCase implements ClassePortIn {

    private final ClassePortOut service;

    public ClasseUseCase(ClassePortOut service) {
        this.service = service;
    }

    @Override
    public Classe cadastrarClasse(Classe classe) {
        return service.cadastrarClasse(classe);
    }

    @Override
    public Classe pegarClassePorId(Integer id) {
        return service.pegarClassePorId(id);
    }

    @Override
    public List<Classe> pegarTodasClasses() {
        return service.pegarTodasClasses();
    }

    @Override
    public void deletarClasse(Integer id) {
        service.deletarClasse(id);
    }
}
