package br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Aula;
import org.springframework.data.domain.AuditorAware;

import java.util.List;

public interface AulaPortOut {

    Aula cadastarAula(Aula aula);

    List<Aula> pegaTodasAulas();

    Aula PegarAulaPorId(Integer id);

    void deletarAula(Integer id);

}
