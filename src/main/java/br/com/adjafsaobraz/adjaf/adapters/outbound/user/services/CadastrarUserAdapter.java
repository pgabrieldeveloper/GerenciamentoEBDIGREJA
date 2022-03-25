package br.com.adjafsaobraz.adjaf.adapters.outbound.user.services;

import br.com.adjafsaobraz.adjaf.adapters.outbound.user.Entities.UserEntity;
import br.com.adjafsaobraz.adjaf.adapters.outbound.user.repository.IUserRepository;
import br.com.adjafsaobraz.adjaf.application.core.domain.user.User;
import br.com.adjafsaobraz.adjaf.application.core.domain.user.ports.out.CadastrarUserPortOut;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CadastrarUserAdapter implements CadastrarUserPortOut {

    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public User cadastrarUser(User user) {
        String passwordHash = encoder.encode(user.getPassword());
        UserEntity userEntity = userRepository.save(UserEntity.builder().mail(user.getMail()).password(passwordHash).roles(user.getRoles()).build());
        return userEntity.getUser();
    }

}
