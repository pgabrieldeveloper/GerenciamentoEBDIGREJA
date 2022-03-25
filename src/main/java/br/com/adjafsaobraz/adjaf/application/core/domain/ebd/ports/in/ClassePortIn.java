package br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.in;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Classe;

import java.util.List;

public interface ClassePortIn {

    Classe cadastrarClasse(Classe classe);

    Classe pegarClassePorId(Integer id);

    List<Classe> pegarTodasClasses();

    void deletarClasse(Integer id);

}
