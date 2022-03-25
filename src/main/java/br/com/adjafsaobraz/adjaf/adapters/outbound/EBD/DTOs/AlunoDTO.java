package br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Integer id;
    private String nome;
    private Integer idade;
    private Integer cdClasse;

}
