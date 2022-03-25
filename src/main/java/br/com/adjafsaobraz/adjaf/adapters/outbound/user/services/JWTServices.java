package br.com.adjafsaobraz.adjaf.adapters.outbound.user.services;

import br.com.adjafsaobraz.adjaf.adapters.outbound.user.Entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@Service
public class JWTServices {

    @Value("${security.jwt.expiracao}")
    private String expiracao;

    @Value("${security.jwt.chave}")
    private String chave;


    public String generateToken(UserEntity user ){
        long expString = Long.valueOf(expiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
        Date date = Date.from(dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant());
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("mail", user.getMail());
        return Jwts.builder()
                .setSubject(user.getMail())
                .setClaims(claims)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, chave).compact();
    }

    public  Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(chave)
                .parseClaimsJws(token).getBody();
    }

    public boolean tokenIsValid(String token){
        try {
            Claims claims = getClaims(token);
            Date data = claims.getExpiration();
            LocalDateTime localdateTime = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(localdateTime);
        }catch (Exception e){
            return false;
        }
    }

    public String getLoginUser(String token)  throws ExpiredJwtException{
       String mail = (String) getClaims(token).get("mail");
        return mail;
    }

}
