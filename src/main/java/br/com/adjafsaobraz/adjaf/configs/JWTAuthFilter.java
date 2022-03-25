package br.com.adjafsaobraz.adjaf.configs;

import br.com.adjafsaobraz.adjaf.adapters.outbound.user.services.JWTServices;
import br.com.adjafsaobraz.adjaf.adapters.outbound.user.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {


    private final JWTServices jwtServices;
    private final UserDetailsServiceImpl userDetailsService;



    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer")) {
            String token = header.split(" ")[1];
            boolean isvalid = jwtServices.tokenIsValid(token);
            if(isvalid){
                String loginUsuario = jwtServices.getLoginUser(token);
                UserDetails user = userDetailsService.loadUserByUsername(loginUsuario);
                UsernamePasswordAuthenticationToken userAutenticate = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                userAutenticate.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userAutenticate);
            }
        }
        filterChain.doFilter(request,response);
    }
}
