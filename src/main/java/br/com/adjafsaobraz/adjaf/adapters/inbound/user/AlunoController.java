package br.com.adjafsaobraz.adjaf.adapters.inbound.user;

import br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.DTOs.AlunoDTO;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Aluno;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.out.AlunoPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoPortIn alunoPort;


    @PostMapping
    public ResponseEntity<AlunoDTO> CadastrarAluno(@RequestBody AlunoDTO aluno){
        Aluno aluno1 = alunoPort.cadastrarAluno(new Aluno(aluno.getNome(), aluno.getIdade(), aluno.getCdClasse()));
        return ResponseEntity.status(HttpStatus.CREATED).body(AlunoDTO.builder()
                        .id(aluno1.getId())
                        .nome(aluno1.getNome())
                        .idade(aluno1.getIdade())
                        .cdClasse(aluno1.getCdClasse())
                .build());
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> pegarTodosAlunos(){
        return ResponseEntity.ok(alunoPort.pegarTodosAlunos().stream().map(al -> AlunoDTO.builder()
                .id(al.getId())
                .nome(al.getNome())
                .idade(al.getIdade())
                .cdClasse(al.getCdClasse())
                .build()).collect(Collectors.toList()));

    }
    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> pegarTodosAlunos(@PathVariable Integer id){
        Aluno al = alunoPort.pegarPorId(id);
        return ResponseEntity.ok(AlunoDTO.builder()
                 .id(al.getId())
                 .nome(al.getNome())
                 .idade(al.getIdade())
                 .cdClasse(al.getCdClasse())
                 .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarALuno (@PathVariable Integer id){
        alunoPort.deleteALuno(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

    }



}
