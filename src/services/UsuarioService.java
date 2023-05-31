package services;

import models.*;

import java.util.List;

public interface UsuarioService {
    void cadastrarUsuario(String nome, String email, String senha, InformacoesPessoais informacoesPessoais, InformacoesFilho informacoesFilho, InstituicaoEnsino instituicaoEnsino);
    Usuario realizarLogin(String email, String senha);
    List<Atividade> recomendarAtividades(Usuario usuario);
    void associarInstituicaoEnsino(Usuario usuario, InstituicaoEnsino instituicaoEnsino);
}