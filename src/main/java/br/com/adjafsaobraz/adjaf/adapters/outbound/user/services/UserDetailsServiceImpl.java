package br.com.adjafsaobraz.adjaf.adapters.outbound.user.services;

import br.com.adjafsaobraz.adjaf.adapters.outbound.exceptions.PassswordNotMatches;
import br.com.adjafsaobraz.adjaf.adapters.outbound.user.DTOs.CredenciaisDTO;
import br.com.adjafsaobraz.adjaf.adapters.outbound.user.Entities.UserEntity;
import br.com.adjafsaobraz.adjaf.adapters.outbound.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final BCryptPasswordEncoder enconder;
    private final IUserRepository userRepository;

    public UserDetails autenticar(CredenciaisDTO userC) {
        UserDetails user = loadUserByUsername(userC.getMail());
        if(enconder.matches(userC.getPassword(), user.getPassword())){
            return user;
        }
        throw new PassswordNotMatches("Password incorreto");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByMail(username);
        if (!userEntity.isPresent()){
            throw  new UsernameNotFoundException("Usuario não encontrado");
        }
        return User.builder().username(userEntity.get().getMail()).roles("USER").password(userEntity.get().getPassword()).build();
    }
}
