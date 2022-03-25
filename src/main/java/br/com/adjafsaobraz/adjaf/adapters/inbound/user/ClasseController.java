package br.com.adjafsaobraz.adjaf.adapters.inbound.user;

import br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.DTOs.ClasseDTO;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Classe;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.ports.in.ClassePortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("classe")
@RequiredArgsConstructor
public class ClasseController {

    private final ClassePortIn classePortIn;

    @GetMapping
    public ResponseEntity<List<ClasseDTO>> pegarTodasAsClasses(){
         return ResponseEntity.ok(classePortIn.pegarTodasClasses().stream().map(cl -> ClasseDTO
                 .builder()
                 .id(cl.getId())
                 .nome(cl.getNome())
                 .build()).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasseDTO> pegarPorId(@PathVariable Integer id){
        Classe classe = classePortIn.pegarClassePorId(id);
        return ResponseEntity.ok(ClasseDTO.builder().id(classe.getId()).nome(classe.getNome()).build());
    }

    @PostMapping
    public ResponseEntity<ClasseDTO> cadastrarClasse(@RequestBody ClasseDTO classeDTO){
        Classe classe = classePortIn.cadastrarClasse(classeDTO.DtoToDomain());
        return ResponseEntity.ok(ClasseDTO.builder().id(classe.getId()).nome(classe.getNome()).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarClasse(@PathVariable Integer id){
        classePortIn.deletarClasse(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
