package br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.adapters;

import br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.Entities.ClasseEntity;
import br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.Repositorio.ClasseRepositorio;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Classe;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out.ClassePortOut;
import br.com.adjafsaobraz.adjaf.exceptions.NotFoundExeption;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClasseAdapter implements ClassePortOut {


    private final ClasseRepositorio repositorio;

    @Override
    public Classe cadastrarClasse(Classe classe) {
        return repositorio.save(ClasseEntity.builder().nome(classe.getNome())
                .build()).entityToDomain();
    }

    @Override
    public Classe pegarClassePorId(Integer id) {
        Optional<ClasseEntity> classeE = repositorio.findById(id);
        if(classeE.isEmpty()){
            throw new NotFoundExeption("Classe com esse id: " + id + " Não encontrado");
        }
        return classeE.get().entityToDomain();

    }

    @Override
    public List<Classe> pegarTodasClasses() {
        return repositorio.findAll().stream().map(cl -> cl.entityToDomain()).collect(Collectors.toList());
    }

    @Override
    public void deletarClasse(Integer id) {
        repositorio.deleteById(id);
    }




}
