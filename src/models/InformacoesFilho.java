package models;

public class InformacoesFilho {
    private String nome;
    private int idade;
    private String sexo;
    private String deficiencia;

    public InformacoesFilho(String nome, int idade, String sexo, String deficiencia) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.deficiencia = deficiencia;
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }
}