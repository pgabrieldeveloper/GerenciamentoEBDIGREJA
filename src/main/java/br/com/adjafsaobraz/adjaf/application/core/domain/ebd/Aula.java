package br.com.adjafsaobraz.adjaf.application.core.domain.ebd;

import java.util.Date;

public class Aula {

    private Integer id;
    private String nome;
    private Date data;
    private Integer cdClasse;

    public Aula(String nome, Date data, Integer cdClasse) {
        this.nome = nome;
        this.data = data;
        this.cdClasse = cdClasse;
    }

    public Aula(Integer id, String nome, Date data, Integer cdClasse) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.cdClasse = cdClasse;
    }

    public Aula() {
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public Integer getCdClasse() {
        return cdClasse;
    }

    public void setCdClasse(Integer cdClasse) {
        this.cdClasse = cdClasse;
    }
}
