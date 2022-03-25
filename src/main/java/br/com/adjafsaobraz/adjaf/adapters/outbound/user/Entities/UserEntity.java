package br.com.adjafsaobraz.adjaf.adapters.outbound.user.Entities;

import br.com.adjafsaobraz.adjaf.application.core.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mail;
    private String password;
    private Integer roles;

    public User getUser(){
        return  new User(this.id,this.mail,this.password,this.roles);
    }


}
