package br.com.adjafsaobraz.adjaf.application.core.domain.ebd;

public class Chamada {

    private Integer id;
    private Integer cdAula;
    private Integer cdAluno;
    private Integer flBiblia;
    private Integer flRevista;
    private Double oferta;

    public Chamada() {
    }

    public Chamada(Integer cdAula, Integer cdAluno, Integer flBiblia, Integer flRevista, Double oferta) {
        this.cdAula = cdAula;
        this.cdAluno = cdAluno;
        this.flBiblia = flBiblia;
        this.flRevista = flRevista;
        this.oferta = oferta;
    }

    public Chamada(Integer id, Integer cdAula, Integer cdAluno, Integer flBiblia, Integer flRevista, Double oferta) {
        this.id = id;
        this.cdAula = cdAula;
        this.cdAluno = cdAluno;
        this.flBiblia = flBiblia;
        this.flRevista = flRevista;
        this.oferta = oferta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCdAula() {
        return cdAula;
    }

    public void setCdAula(Integer cdAula) {
        this.cdAula = cdAula;
    }

    public Integer getCdAluno() {
        return cdAluno;
    }

    public void setCdAluno(Integer cdAluno) {
        this.cdAluno = cdAluno;
    }

    public Integer getFlBiblia() {
        return flBiblia;
    }

    public void setFlBiblia(Integer flBiblia) {
        this.flBiblia = flBiblia;
    }

    public Integer getFlRevista() {
        return flRevista;
    }

    public void setFlRevista(Integer flRevista) {
        this.flRevista = flRevista;
    }

    public Double getOferta() {
        return oferta;
    }

    public void setOferta(Double oferta) {
        this.oferta = oferta;
    }
}
