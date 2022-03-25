package br.com.adjafsaobraz.adjaf.adapters.outbound.user.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDTO {
    public String login;
    public  String token;
}
