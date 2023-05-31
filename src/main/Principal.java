package main;

import models.*;
import services.UsuarioService;
import services.UsuarioServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioService usuarioService = new UsuarioServiceImpl();
    private static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            if (usuarioLogado == null) {
                exibirMenuLogin();
                int opcao = lerOpcao();

                switch (opcao) {
                    case 1:
                        cadastrarUsuario();
                        break;
                    case 2:
                        realizarLogin();
                        break;
                    case 3:
                        executando = false;
                        System.out.println("Programa encerrado.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                exibirMenuUsuario();
                int opcao = lerOpcao();

                switch (opcao) {
                    case 1:
                        cadastrarInformacoesPessoais();
                        break;
                    case 2:
                        cadastrarFilho();
                        break;
                    case 3:
                        recomendarAtividades();
                        break;
                    case 4:
                        associarInstituicaoEnsino();
                        break;
                    case 5:
                        usuarioLogado = null;
                        System.out.println("Logout realizado com sucesso.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }

    private static void exibirMenuLogin() {
        System.out.println("===== MENU LOGIN =====");
        System.out.println("1. Cadastrar usuário");
        System.out.println("2. Realizar login");
        System.out.println("3. Sair");
        System.out.println("======================");
    }

    private static void exibirMenuUsuario() {
        System.out.println("===== MENU USUÁRIO =====");
        System.out.println("1. Cadastrar informações pessoais");
        System.out.println("2. Cadastrar filho");
        System.out.println("3. Recomendar atividades");
        System.out.println("4. Associar instituição de ensino");
        System.out.println("5. Logout");
        System.out.println("========================");
    }

    private static int lerOpcao() {
        System.out.print("Digite a opção desejada: ");
        return scanner.nextInt();
    }

    private static void cadastrarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.next();

        System.out.print("Digite o email do usuário: ");
        String email = scanner.next();

        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.next();

        InformacoesPessoais informacoesPessoais = new InformacoesPessoais(nome, 0, ""); // Altere a idade conforme necessário

        usuarioService.cadastrarUsuario(nome, email, senha, informacoesPessoais, null, null);
        System.out.println("Cadastro realizado com sucesso!");
    }

    private static void realizarLogin() {
        System.out.print("Digite o email: ");
        String email = scanner.next();

        System.out.print("Digite a senha: ");
        String senha = scanner.next();

        Usuario usuario = usuarioService.realizarLogin(email, senha);

        if (usuario != null) {
            usuarioLogado = usuario;
            System.out.println("Login realizado com sucesso! Bem-vindo, " + usuario.getNome() + ".");
        } else {
            System.out.println("Credenciais inválidas. Tente novamente.");
        }
    }

    private static void cadastrarInformacoesPessoais() {
        System.out.print("Digite o seu nome: ");
        String nome = scanner.next();

        System.out.print("Digite a sua idade: ");
        int idade = scanner.nextInt();

        System.out.print("Digite a sua profissão: ");
        String profissao = scanner.nextLine();
        scanner.nextLine(); // Consumir a nova linha

        InformacoesPessoais informacoesPessoais = new InformacoesPessoais(nome, idade, profissao);
        usuarioLogado.setInformacoesPessoais(informacoesPessoais);
        System.out.println("Informações pessoais cadastradas com sucesso!");
    }

    private static void cadastrarFilho() {
        System.out.print("Digite o nome do filho: ");
        String nomeFilho = scanner.next();

        System.out.print("Digite a idade do filho: ");
        int idadeFilho = scanner.nextInt();

        System.out.print("Digite o sexo do filho: ");
        String sexoFilho = scanner.next();

        System.out.print("Digite a deficiência do filho (ou deixe em branco caso não haja): ");
        String deficienciaFilho = scanner.nextLine();
        scanner.nextLine(); // Consumir a nova linha

        InformacoesFilho informacoesFilho = new InformacoesFilho(nomeFilho, idadeFilho, sexoFilho, deficienciaFilho);
        usuarioLogado.setInformacoesFilho(informacoesFilho);
        System.out.println("Cadastro do filho realizado com sucesso!");
    }

    private static void recomendarAtividades() {
        if (usuarioLogado.getInformacoesFilho() == null) {
            System.out.println("Você precisa cadastrar as informações do seu filho primeiro.");
            return;
        }

        List<Atividade> atividadesRecomendadas = usuarioService.recomendarAtividades(usuarioLogado);
        if (atividadesRecomendadas.isEmpty()) {
            System.out.println("Não há atividades recomendadas para o seu filho no momento.");
        } else {
            System.out.println("Atividades recomendadas para o seu filho:");
            for (Atividade atividade : atividadesRecomendadas) {
                System.out.println("Título: " + atividade.getTitulo());
                System.out.println("Descrição: " + atividade.getDescricao());
                System.out.println();
            }
        }
    }

    private static void associarInstituicaoEnsino() {
        if (usuarioLogado.getInformacoesFilho() == null) {
            System.out.println("Você precisa cadastrar as informações do seu filho primeiro.");
            return;
        }

        System.out.print("Digite o nome da instituição de ensino: ");
        String nomeInstituicao = scanner.next();

        System.out.print("Digite o endereço da instituição de ensino: ");
        String enderecoInstituicao = scanner.nextLine();
        scanner.nextLine(); // Consumir a nova linha

        InstituicaoEnsino instituicaoEnsino = new InstituicaoEnsino(nomeInstituicao, enderecoInstituicao);
        usuarioService.associarInstituicaoEnsino(usuarioLogado, instituicaoEnsino);
        System.out.println("Instituição de ensino associada com sucesso!");
    }
}