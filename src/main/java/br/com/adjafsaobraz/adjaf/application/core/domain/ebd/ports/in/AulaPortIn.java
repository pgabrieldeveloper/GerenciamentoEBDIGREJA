package br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.in;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Aula;
import java.util.List;

public interface AulaPortIn {

    Aula cadastarAula(Aula aula);

    List<Aula> pegaTodasAulas();

    Aula PegarAulaPorId(Integer id);

    void deletarAula(Integer id);

}
