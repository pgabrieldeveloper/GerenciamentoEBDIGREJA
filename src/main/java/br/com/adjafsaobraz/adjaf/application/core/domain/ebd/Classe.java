package br.com.adjafsaobraz.adjaf.application.core.domain.ebd;

public class Classe {

    private Integer id;
    private String nome;

    public Classe(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Classe(String nome) {
        this.nome = nome;
    }

    public Classe() {


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
