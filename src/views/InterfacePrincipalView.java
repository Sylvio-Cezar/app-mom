package views;

import models.*;
import services.UsuarioService;
import services.UsuarioServiceImpl;

import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfacePrincipalView {
    private Scanner scanner;
    private UsuarioService usuarioService;
    private Usuario usuarioLogado;
    private List<InformacoesFilho> filhosCadastrados;
    private List<InstituicaoEnsino> instituicoesCadastradas;

    public InterfacePrincipalView() {
        this.scanner = new Scanner(System.in);
        this.usuarioService = new UsuarioServiceImpl();
        this.usuarioLogado = null;
        this.filhosCadastrados = new ArrayList<>();
        this.instituicoesCadastradas = new ArrayList<>();
    }

    public void executar() throws ParseException, InterruptedException {
        boolean executando = true;

        while (executando) {
            if (this.usuarioLogado == null) {
                exibirMenuLogin();
                int opcao = lerOpcao();

                switch (opcao) {
                    case 1 -> cadastrarUsuario();
                    case 2 -> realizarLogin();
                    case 3 -> {
                        executando = false;
                        System.out.println("\nPrograma encerrado.");
                    }
                    default -> System.out.println("\nOpção inválida. Tente novamente.");
                }
                TimeUnit.MILLISECONDS.sleep(1500);
            } else {
                exibirMenuUsuario();
                int opcao = lerOpcao();

                switch (opcao) {
                    case 1 -> cadastrarInformacoesPessoais();
                    case 2 -> cadastrarFilho();
                    case 3 -> listarFilhosCadastrados();
                    case 4 -> associarInstituicaoEnsino();
                    case 5 -> recomendarAtividades();
                    case 6 -> exibirMenuConfiguracoes();
                    case 7 -> {
                        this.usuarioLogado = null;
                        System.out.println("\nLogout realizado com sucesso.");
                    }
                    default -> System.out.println("\nOpção inválida. Tente novamente.");
                }
                TimeUnit.MILLISECONDS.sleep(1500);
            }
        }
    }

    private void exibirMenuLogin() {
        System.out.println("\n===== LOGIN =====");
        System.out.println("1. Cadastrar usuário");
        System.out.println("2. Realizar login");
        System.out.println("3. Sair");
        System.out.println("======================");
    }

    private void exibirMenuUsuario() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Cadastrar informações pessoais");
        System.out.println("2. Cadastrar filho(a)");
        System.out.println("3. Listar filhos cadastrados");
        System.out.println("4. Associar instituição de ensino");
        System.out.println("5. Recomendar atividades");
        System.out.println("6. Configurações");
        System.out.println("7. Logout");
        System.out.println("========================");
    }

    private void exibirMenuConfiguracoes() throws InterruptedException {
        System.out.println("\n===== CONFIGURAÇÕES =====");
        //System.out.println("1. Atualizar usuário");
        System.out.println("1. Deletar usuário");
        System.out.println("2. Voltar ao menu principal");
        System.out.println("========================");

        int opcao = lerOpcao();
        switch (opcao) {
            /* case 1:
                atualizarUsuario();
                break; */
            case 1:
                deletarUsuario();
                break;
            case 2:
                // Voltar ao menu principal
                break;
            default:
                System.out.println("\nOpção inválida. Tente novamente.");
        }
        TimeUnit.MILLISECONDS.sleep(1500);
    }

    private int lerOpcao() {
        System.out.print("Digite a opção desejada: ");
        return this.scanner.nextInt();
    }

    private void cadastrarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nome = this.scanner.next();

        System.out.print("Digite o email do usuário: ");
        String email = this.scanner.next();

        System.out.print("Digite a senha do usuário: ");
        String senha = this.scanner.next();

        InformacoesPessoais informacoesPessoais = new InformacoesPessoais(nome, 0, "", "", "", "");

        this.usuarioService.cadastrarUsuario(nome, email, senha, informacoesPessoais, null);
        System.out.println("\nCadastro realizado com sucesso!");
    }

    /* private void atualizarUsuario() {
        System.out.print("Digite o novo nome do usuário: ");
        String novoNome = this.scanner.next();

        System.out.print("Digite o novo email do usuário: ");
        String novoEmail = this.scanner.next();

        System.out.print("Digite a nova senha do usuário: ");
        String novaSenha = this.scanner.next();

        InformacoesPessoais informacoesPessoais = this.usuarioLogado.getInformacoesPessoais();
        InformacoesFilho informacoesFilho = this.usuarioLogado.getInformacoesFilho();

        this.usuarioLogado = new Usuario(novoNome, novoEmail, novaSenha, informacoesPessoais, informacoesFilho);
        this.usuarioService.atualizarUsuario(this.usuarioLogado);
        System.out.println("\nUsuário atualizado com sucesso!");
    } */

    private void deletarUsuario() {
        this.usuarioService.deletarUsuario(this.usuarioLogado);
        this.usuarioLogado = null;
        System.out.println("\nUsuário deletado com sucesso!");
    }

    private void realizarLogin() {
        System.out.print("Digite o email: ");
        String email = this.scanner.next();

        System.out.print("Digite a senha: ");
        String senha = this.scanner.next();

        Usuario usuario = this.usuarioService.realizarLogin(email, senha);

        if (usuario != null) {
            this.usuarioLogado = usuario;
            System.out.println("\nLogin realizado com sucesso! Bem-vindo, " + usuario.getNome() + ".");
        } else {
            System.out.println("\nCredenciais inválidas. Tente novamente.");
        }
    }

    private void cadastrarInformacoesPessoais() {
        System.out.print("Digite o seu nome: ");
        String nome = this.scanner.next();

        System.out.print("Digite a sua idade: ");
        int idade = this.scanner.nextInt();

        System.out.print("Digite o seu CPF: ");
        String cpf = this.scanner.next();

        System.out.print("Digite o seu RG: ");
        String rg = this.scanner.next();

        System.out.print("Digite o seu sexo: ");
        String sexo = this.scanner.next();

        System.out.print("Digite a sua profissão: ");
        String profissao = this.scanner.nextLine();
        this.scanner.nextLine();

        InformacoesPessoais informacoesPessoais = new InformacoesPessoais(nome, idade, sexo, cpf, rg, profissao);
        this.usuarioLogado.setInformacoesPessoais(informacoesPessoais);
        System.out.println("\nInformações pessoais cadastradas com sucesso!");
    }

    private void cadastrarFilho() {
        System.out.print("Digite o nome do(a) filho(a): ");
        String nomeFilho = this.scanner.next();

        System.out.print("Digite a idade do(a) filho(a): ");
        int idadeFilho = this.scanner.nextInt();

        System.out.print("Digite o CPF do(a) filho(a): ");
        String cpfFilho = this.scanner.next();

        System.out.print("Digite o RG do(a) filho(a): ");
        String rgFilho = this.scanner.next();

        System.out.print("Digite o sexo do(a) filho(a): ");
        String sexoFilho = this.scanner.next();

        System.out.print("Digite a deficiência do(a) filho(a) (digite nenhuma caso não haja): ");
        String deficienciaFilho = this.scanner.next();

        InformacoesFilho informacoesFilho = new InformacoesFilho(nomeFilho, idadeFilho, sexoFilho, cpfFilho, rgFilho, deficienciaFilho);
        this.filhosCadastrados.add(informacoesFilho);
        System.out.println("\nCadastro do(a) filho(a) realizado com sucesso!");
    }

    private void recomendarAtividades() {
        if (this.filhosCadastrados.isEmpty()) {
            System.out.println("\nVocê precisa cadastrar as informações do seu filho primeiro.");
            return;
        }

        System.out.print("Digite o CPF do(a) filho(a) para o qual deseja recomendar atividades: ");
        String cpfFilho = this.scanner.next();

        InformacoesFilho informacoesFilho = buscarFilhoPorCpf(cpfFilho);
        if (informacoesFilho == null) {
            System.out.println("\nFilho não encontrado. Verifique o CPF e tente novamente.");
            return;
        }

        Atividade atividade = new Atividade();
        atividade.atividadesRecomendadas(informacoesFilho.getIdade());

        if (atividade.getTitulo() == null) {
            System.out.println("\nNão há atividades recomendadas para o seu filho no momento.");
        } else {
            System.out.println("Atividades recomendadas para o(a) filho(a) " + informacoesFilho.getNome() + ":");
            System.out.println("Título: " + atividade.getTitulo());
            System.out.println("Descrição: " + atividade.getDescricao());
        }
    }

    private void associarInstituicaoEnsino() {
        if (this.filhosCadastrados.isEmpty()) {
            System.out.println("\nVocê precisa cadastrar as informações do seu filho primeiro.");
            return;
        }

        System.out.print("Digite o CPF do(a) filho(a) para o qual deseja associar uma instituição de ensino: ");
        String cpfFilho = this.scanner.next();

        InformacoesFilho informacoesFilho = buscarFilhoPorCpf(cpfFilho);
        if (informacoesFilho == null) {
            System.out.println("\nFilho não encontrado. Verifique o CPF e tente novamente.");
            return;
        }

        System.out.print("Digite o nome do(a) professor(a) responsável: ");
        String professorResponsavel = this.scanner.next();

        System.out.print("Digite o nome da instituição de ensino: ");
        String instituicaoEnsino = this.scanner.nextLine();
        this.scanner.nextLine();

        System.out.print("Digite o endereço da instituição de ensino: ");
        String enderecoInstituicao = this.scanner.nextLine();
        this.scanner.nextLine();

        InstituicaoEnsino instituicao = new InstituicaoEnsino(instituicaoEnsino, enderecoInstituicao, professorResponsavel);
        this.instituicoesCadastradas.add(instituicao);

        informacoesFilho.setNomeInstituicao(instituicaoEnsino);
        informacoesFilho.setProfessorResponsavel(professorResponsavel);
        System.out.println("\nInstituição de ensino associada com sucesso ao(a) filho(a) " + informacoesFilho.getNome() + ".");
    }

    private void listarFilhosCadastrados() {
        System.out.println("\n===== FILHOS CADASTRADOS =====");
        if (this.filhosCadastrados.isEmpty()) {
            System.out.println("\nNenhum filho cadastrado.");
        } else {
            for (InformacoesFilho filho : this.filhosCadastrados) {
                System.out.println("Nome: " + filho.getNome());
                System.out.println("CPF: " + filho.getCpf());
                System.out.println("Idade: " + filho.getIdade());
                System.out.println("Sexo: " + filho.getSexo());
                System.out.println("RG: " + filho.getRg());
                System.out.println("Deficiência: " + filho.getDeficiencia());
                System.out.println("Instituição de Ensino: " + filho.getNomeInstituicao());
                System.out.println("Professor(a) responsável: " + filho.getProfessorResponsavel());
                System.out.println("==============================");
            }
        }
    }

    private InformacoesFilho buscarFilhoPorCpf(String cpf) {
        for (InformacoesFilho filho : this.filhosCadastrados) {
            if (filho.getCpf().equals(cpf)) {
                return filho;
            }
        }
        return null;
    }
}