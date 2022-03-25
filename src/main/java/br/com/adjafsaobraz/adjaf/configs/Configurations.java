package br.com.adjafsaobraz.adjaf.configs;
import br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.adapters.AlunoAdapter;
import br.com.adjafsaobraz.adjaf.adapters.outbound.EBD.adapters.ClasseAdapter;
import br.com.adjafsaobraz.adjaf.adapters.outbound.user.services.CadastrarUserAdapter;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.services.AlunoUseCase;
import br.com.adjafsaobraz.adjaf.application.core.domain.ebd.services.ClasseUseCase;
import br.com.adjafsaobraz.adjaf.application.core.domain.user.services.RegisterUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Configurations {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public RegisterUserUseCase registerUserUseCase (CadastrarUserAdapter adapter){
        return  new RegisterUserUseCase(adapter);
    }

    @Bean
    public AlunoUseCase alunoUseCase (AlunoAdapter adapter){
        return  new AlunoUseCase(adapter);
    }

    @Bean
    public ClasseUseCase classeUseCase (ClasseAdapter adapter) {
        return  new ClasseUseCase(adapter);
    }

}
