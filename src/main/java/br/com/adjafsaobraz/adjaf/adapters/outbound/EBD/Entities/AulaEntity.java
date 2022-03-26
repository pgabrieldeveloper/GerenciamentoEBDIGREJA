package br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.Entities;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Aula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_aula",schema = "cadastro" )
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AulaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Date data;
    private Integer cdClasse;

    public Aula entityToDomain(){
        return new Aula(this.id,this.nome,this.data,this.cdClasse);
    }

}
