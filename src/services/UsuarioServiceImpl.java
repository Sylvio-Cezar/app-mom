package services;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {
    private List<Usuario> usuarios;

    public UsuarioServiceImpl() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void cadastrarUsuario(String nome, String email, String senha, InformacoesPessoais informacoesPessoais, InformacoesFilho informacoesFilho) {
        Usuario usuario = new Usuario(nome, email, senha, informacoesPessoais, informacoesFilho);
        this.usuarios.add(usuario);
    }

    /* @Override
    public void atualizarUsuario(Usuario usuario) {
        for (int i = 0; i < this.usuarios.size(); i++) {
            if (this.usuarios.get(i).getEmail() == usuario.getEmail()) {
                this.usuarios.set(i, usuario);
                break;
            }
        }
    } */

    @Override
    public void deletarUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    @Override
    public Usuario realizarLogin(String email, String senha) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
}