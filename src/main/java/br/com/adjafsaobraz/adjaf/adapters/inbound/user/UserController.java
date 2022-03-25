package br.com.adjafsaobraz.adjaf.adapters.inbound.user;

import br.com.adjafsaobraz.adjaf.adapters.outbound.user.DTOs.CredenciaisDTO;
import br.com.adjafsaobraz.adjaf.adapters.outbound.user.DTOs.TokenDTO;
import br.com.adjafsaobraz.adjaf.adapters.outbound.user.Entities.UserEntity;
import br.com.adjafsaobraz.adjaf.adapters.outbound.user.services.JWTServices;
import br.com.adjafsaobraz.adjaf.adapters.outbound.user.services.UserDetailsServiceImpl;
import br.com.adjafsaobraz.adjaf.application.core.domain.user.User;
import br.com.adjafsaobraz.adjaf.application.core.domain.user.ports.in.CadastrarUserPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CadastrarUserPortIn cadastrarUserPortIn;
    private final UserDetailsServiceImpl authService;
    private final JWTServices jwtServices;

    @PostMapping("register")
    public User register(@RequestBody User user) {
        return cadastrarUserPortIn.cadastrarUser(user);
    }

    @PostMapping("auth")
    public ResponseEntity<TokenDTO> auth(@RequestBody CredenciaisDTO user) {
       UserDetails userD = authService.autenticar(user);
        try {
           TokenDTO token = TokenDTO.builder()
                    .login(userD.getUsername()).
                    token(jwtServices.generateToken(UserEntity.builder().mail(userD.getUsername()).build())).build();
            return ResponseEntity.ok(token);
        } catch (Exception e){
            throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }

    }





}
