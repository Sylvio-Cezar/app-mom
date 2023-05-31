package models;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private InformacoesPessoais informacoesPessoais;
    private InformacoesFilho informacoesFilho;
    private InstituicaoEnsino instituicaoEnsino;

    public Usuario(String nome, String email, String senha, InformacoesPessoais informacoesPessoais, InformacoesFilho informacoesFilho, InstituicaoEnsino instituicaoEnsino) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.informacoesPessoais = informacoesPessoais;
        this.informacoesFilho = informacoesFilho;
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public InformacoesPessoais getInformacoesPessoais() {
        return informacoesPessoais;
    }

    public void setInformacoesPessoais(InformacoesPessoais informacoesPessoais) {
        this.informacoesPessoais = informacoesPessoais;
    }

    public InformacoesFilho getInformacoesFilho() {
        return informacoesFilho;
    }

    public void setInformacoesFilho(InformacoesFilho informacoesFilho) {
        this.informacoesFilho = informacoesFilho;
    }

    public InstituicaoEnsino getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    public void setInstituicaoEnsino(InstituicaoEnsino instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }
}