package br.com.adjafsaobraz.adjaf.adapters.outbound.exceptions;

public class PassswordNotMatches extends RuntimeException {
    public PassswordNotMatches(String msg){
        super(msg);
    }
}
