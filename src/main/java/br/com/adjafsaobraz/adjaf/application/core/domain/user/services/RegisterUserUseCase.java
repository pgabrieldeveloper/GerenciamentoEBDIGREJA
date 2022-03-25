package br.com.adjafsaobraz.adjaf.application.core.domain.user.services;

import br.com.adjafsaobraz.adjaf.application.core.domain.user.User;
import br.com.adjafsaobraz.adjaf.application.core.domain.user.ports.in.CadastrarUserPortIn;
import br.com.adjafsaobraz.adjaf.application.core.domain.user.ports.out.CadastrarUserPortOut;

public class RegisterUserUseCase implements CadastrarUserPortIn {

    private final CadastrarUserPortOut cadastrarUserPortOut;

    public RegisterUserUseCase(CadastrarUserPortOut cadastrarUserPortOut) {
        this.cadastrarUserPortOut = cadastrarUserPortOut;
    }

    @Override
    public User cadastrarUser(User user) {
        User u = cadastrarUserPortOut.cadastrarUser(user);
        return u;
    }
}
