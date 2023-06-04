package models;

public class InstituicaoEnsino {
    private String nome;
    private String endereco;
    private String professorResponsavel;

    public InstituicaoEnsino(String nome, String endereco, String professorResponsavel) {
        this.nome = nome;
        this.endereco = endereco;
        this.professorResponsavel = professorResponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }
}