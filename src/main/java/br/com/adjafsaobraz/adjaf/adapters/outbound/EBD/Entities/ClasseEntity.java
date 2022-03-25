package br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.Entities;

import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.Classe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_classe", schema = "cadastro")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClasseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;


    public Classe entityToDomain(){
        return new Classe(this.id, this.nome);
    }

}
