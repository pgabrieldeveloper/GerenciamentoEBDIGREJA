package br.com.adjafsaobraz.adjaf.application.core.domain.user.ports.out;

import br.com.adjafsaobraz.adjaf.application.core.domain.user.User;

public interface CadastrarUserPortOut {
    User cadastrarUser(User user);

}
