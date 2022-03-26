package br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.adapters;

import br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.Entities.AulaEntity;
import br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.Repositorio.AulaRepositorio;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Aula;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out.AulaPortOut;
import br.com.adjafsaobraz.adjaf.exceptions.NotFoundExeption;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AulaAdapter implements AulaPortOut {


    private final AulaRepositorio repositorio;

    @Override
    public Aula cadastarAula(Aula aula) {
        AulaEntity aulaEntity = AulaEntity
                .builder()
                .nome(aula.getNome())
                .data(aula.getData())
                .cdClasse(aula.setCdClasse())
                .build();
        return  repositorio.save(aulaEntity).entityToDomain();
    }

    @Override
    public List<Aula> pegaTodasAulas() {
        return repositorio.findAll().stream().map(al -> al.entityToDomain()).collect(Collectors.toList());
    }

    @Override
    public Aula PegarAulaPorId(Integer id) {
        Optional<AulaEntity> aulaEntity = repositorio.findAllById(id);
        if(aulaEntity.isEmpty()){
            throw new NotFoundExeption("Aluna com esse id: " + id + " Não encontrado");
        }
        return aulaEntity.get().entityToDomain();
    }

    @Override
    public void deletarAula(Integer id) {
        repositorio.deleteById(id);
    }
}
