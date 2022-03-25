package br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.DTOs;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Classe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClasseDTO {

    private Integer id;

    private String nome;


    public Classe DtoToDomain(){
        return  new Classe(this.id, this.nome);
    }

}
