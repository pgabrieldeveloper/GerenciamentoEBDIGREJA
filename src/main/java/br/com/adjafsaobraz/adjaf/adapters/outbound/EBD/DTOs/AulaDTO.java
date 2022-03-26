package br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.DTOs;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Aula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AulaDTO {

    private Integer id;
    private String nome;
    private Date data;
    private Integer cdClasse;

    public Aula DtoToDomain(){
        return new Aula(this.id,this.nome,this.data,this.cdClasse);
    }

}
