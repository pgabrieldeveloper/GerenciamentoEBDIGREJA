package br.com.adjafsaobraz.adjaf.application.core.domain.ebd;

public class Aluno {

    private Integer id;
    private String nome;
    private Integer idade;
    private Integer cdClasse;

    public Aluno() {
    }

    public Aluno(Integer id, String nome, Integer idade, Integer cdClasse) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cdClasse = cdClasse;
    }

    public Aluno( String nome, Integer idade, Integer cdClasse) {
        this.nome = nome;
        this.idade = idade;
        this.cdClasse = cdClasse;
    }

    public int getId() {
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public int getCdClasse() {
        return cdClasse;
    }

    public void setCdClasse(Integer cdClasse) {
        this.cdClasse = cdClasse;
    }
}

