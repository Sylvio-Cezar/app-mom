package services;

import models.*;

public interface UsuarioService {
    void cadastrarUsuario(String nome, String email, String senha, InformacoesPessoais informacoesPessoais, InformacoesFilho informacoesFilho);
    //void atualizarUsuario(Usuario usuario);
    void deletarUsuario(Usuario usuario);
    Usuario realizarLogin(String email, String senha);
}