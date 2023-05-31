package services;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {
    private List<Usuario> usuarios;

    public UsuarioServiceImpl() {
        usuarios = new ArrayList<>();
    }

    @Override
    public void cadastrarUsuario(String nome, String email, String senha, InformacoesPessoais informacoesPessoais, InformacoesFilho informacoesFilho, InstituicaoEnsino instituicaoEnsino) {
        Usuario usuario = new Usuario(nome, email, senha, informacoesPessoais, informacoesFilho, instituicaoEnsino);
        usuarios.add(usuario);
    }

    @Override
    public Usuario realizarLogin(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Atividade> recomendarAtividades(Usuario usuario) {
        // Lógica para recomendar atividades com base na faixa etária, sexo e deficiência (se houver) da criança
        return new ArrayList<>();
    }

    @Override
    public void associarInstituicaoEnsino(Usuario usuario, InstituicaoEnsino instituicaoEnsino) {
        usuario.setInstituicaoEnsino(instituicaoEnsino);
    }
}