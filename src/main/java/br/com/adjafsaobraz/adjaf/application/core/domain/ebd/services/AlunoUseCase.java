package br.com.adjafsaobraz.adjaf.application.core.domain.ebd.services;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Aluno;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out.AlunoPortIn;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out.AlunoPortOut;

import java.util.List;

public class AlunoUseCase implements AlunoPortIn {

    private final AlunoPortOut alunoPort;

    public AlunoUseCase(AlunoPortOut alunoPort) {
        this.alunoPort = alunoPort;
    }

    @Override
    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoPort.cadastrarAluno(aluno);
    }

    @Override
    public List<Aluno> pegarTodosAlunos() {
        return alunoPort.pegarTodosAlunos();
    }

    @Override
    public void deleteALuno(Integer id) {
        alunoPort.deleteALuno(id);
    }

    @Override
    public Aluno pegarPorId(Integer id) {
        return alunoPort.pegarPorId(id);
    }
}
