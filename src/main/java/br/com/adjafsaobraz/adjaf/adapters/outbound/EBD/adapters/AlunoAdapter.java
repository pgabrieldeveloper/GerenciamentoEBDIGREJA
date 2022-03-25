package br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.adapters;

import br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.Entities.AlunoEntity;
import br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.Repositorio.AlunoRepositorio;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Aluno;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out.AlunoPortOut;
import br.com.adjafsaobraz.adjaf.exceptions.NotFoundExeption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoAdapter implements AlunoPortOut {
    private final AlunoRepositorio repositorio;
    @Override
    public Aluno cadastrarAluno(Aluno aluno) {
       AlunoEntity alunoEntity =  AlunoEntity.builder()
                        .nome(aluno.getNome())
                        .idade(aluno.getIdade())
                        .cdClasse(aluno.getCdClasse())
                        .build();
       AlunoEntity alunoEntity1 = repositorio.save(alunoEntity);
       return new Aluno(alunoEntity1.getId(), alunoEntity1.getNome(), alunoEntity1.getIdade(), alunoEntity1.getCdClasse());
    }

    @Override
    public List<Aluno> pegarTodosAlunos() {
        return repositorio.findAll()
                .stream()
                .map(aluno -> new Aluno(aluno.getId(),aluno.getNome(),aluno.getIdade(),aluno.getCdClasse())).collect(Collectors.toList());

    }

    @Override
    public void deleteALuno(Integer id) {

        repositorio.deleteById(id);
    }

    @Override
    public Aluno pegarPorId(Integer id) throws NotFoundExeption  {
            Optional<AlunoEntity>  alunoEntity = repositorio.findById(id);
            if(alunoEntity.isEmpty()){
                throw new NotFoundExeption("Aluno com esse id: " + id + " Não encontrado");
            }
            AlunoEntity alunoEntity1 = alunoEntity.get();
            return new Aluno(alunoEntity1.getId(), alunoEntity1.getNome(), alunoEntity1.getIdade(), alunoEntity1.getCdClasse());
    }

}
