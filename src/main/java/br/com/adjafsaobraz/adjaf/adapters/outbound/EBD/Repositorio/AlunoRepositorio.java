package br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.Repositorio;

import br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.Entities.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepositorio extends JpaRepository<AlunoEntity, Integer> {
}
