package br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Aluno;

import java.util.List;

public interface AlunoPortIn {
    Aluno cadastrarAluno(Aluno aluno);

    List<Aluno> pegarTodosAlunos();

    void deleteALuno(Integer id);

    Aluno pegarPorId(Integer id);
}
