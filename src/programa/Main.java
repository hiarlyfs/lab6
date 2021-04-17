package programa;

import facade.PessoaFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static PessoaFacade pessoaFacade = new PessoaFacade();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) {
                break;
            }

            if (opcao == 1) {
                cadastrarPessoa(sc);
                continue;
            }

            if (opcao == 2) {
                atualizarPessoa(sc);
                continue;
            }

            if (opcao == 3) {
                mostrarPessoa(sc);
                continue;
            }

            if (opcao == 4) {
                mostrarSituacaoPessoa(sc);
                continue;
            }

            if (opcao == 5) {
                avancarSituacaoPessoa(sc);
                continue;
            }

            System.out.println("SITUACAO INVÁLIDA");
        }
    }


    private static void mostrarMenu() {
        System.out.println("Menu:" + System.lineSeparator() +
                "1. Cadastrar pessoa" + System.lineSeparator() +
                "2. Atualizar pessoa" + System.lineSeparator() +
                "3. Buscar pessoa" + System.lineSeparator() +
                "4. Mostar situacao pessoa" + System.lineSeparator() +
                "5. Avancar situacao pessoa" + System.lineSeparator() +
                "0. Encerrar");

    }


    private static void cadastrarPessoa(Scanner sc) {
        System.out.println("1: Digite  o nome completo");
        String nomeCompleto = sc.nextLine();

        System.out.println("2: Digite  o cpf");
        String cpf = sc.nextLine();

        System.out.println("3: Digite  o endereco");
        String endereco = sc.nextLine();

        System.out.println("4: Digite  o cartao do SUS");
        String cartaoSus = sc.nextLine();

        System.out.println("5: Digite o email");
        String email = sc.nextLine();

        System.out.println("6: Digite o telefone ");
        String telefone = sc.nextLine();

        System.out.println("7: Digite a profissão");
        String profissao = sc.nextLine();

        System.out.println("8: Digite a idade");
        int idade = sc.nextInt();
        sc.nextLine();

        List<String> cormobidates = obterCormobidates(sc);

        int situacao = obterSitucao(sc);

        String resultado = pessoaFacade.cadastrarPessoa(nomeCompleto, cpf, idade,
                endereco,cartaoSus, email, telefone, profissao, cormobidates, situacao);

        System.out.println(resultado);
    }

    private static void atualizarPessoa(Scanner sc) {
        System.out.println("1: Digite  o cpf já cadastrado");
        String cpf = sc.nextLine();

        System.out.println("2: Digite  o nome completo");
        String nomeCompleto = sc.nextLine();

        System.out.println("3: Digite  o endereco");
        String endereco = sc.nextLine();

        System.out.println("4: Digite  o cartao do SUS");
        String cartaoSus = sc.nextLine();

        System.out.println("5: Digite o email");
        String email = sc.nextLine();

        System.out.println("6: Digite o telefone ");
        String telefone = sc.nextLine();

        System.out.println("7: Digite a profissão");
        String profissao = sc.nextLine();

        System.out.println("8: Digite a idade");
        int idade = sc.nextInt();
        sc.nextLine();

        List<String> cormobidates = obterCormobidates(sc);

        int situacao = obterSitucao(sc);

        String resultado = pessoaFacade.atualizarPessoa(nomeCompleto, cpf, idade,
                endereco,cartaoSus, email, telefone, profissao, cormobidates, situacao);

        System.out.println(resultado);
    }





    private static List<String> obterCormobidates(Scanner sc) {
        System.out.println("Adicionar cormobidades: ");
        List<String> cormobidades = new ArrayList<>();

        int opcao = -1;

        while (true) {
            System.out.println("Selecione uma opção: ");
            System.out.println("1. Adicionar nova cormobidade");
            System.out.println("0. Encerrar adição de novas cormobidades");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Cormobidade: ");
                String cormobidade = sc.nextLine();
                cormobidades.add(cormobidade);
            } else if (opcao == 0) {
                break;
            } else {
                System.out.println("Opção invalida! ");
            }
        }

        return cormobidades;
    }


    private static int obterSitucao(Scanner sc) {
        int opcao = -1;
        while (opcao < 1 || opcao > 5) {
            System.out.println("6 . Escolher situcação inicial:");
            System.out.println("    1 - Nao habilitado para vacina");
            System.out.println("    2 - Habilitado para tomar a 1 dose");
            System.out.println("    3 - Tomou a 1 dose");
            System.out.println("    4 - Habilitada para tomar a 2 dose");
            System.out.println("    5 - Finalizada vacinação");
            opcao = sc.nextInt();
            sc.nextLine();
        }

        return opcao;
    }

    private static void mostrarPessoa(Scanner sc) {
        System.out.println("Digite o cpf");
        String cpf = sc.nextLine();
        String resultdadoBusca = pessoaFacade.getPessoa(cpf);
        System.out.println(resultdadoBusca);
    }


    private static void mostrarSituacaoPessoa(Scanner sc) {
        System.out.println("Digite o cpf");
        String cpf = sc.nextLine();
        String resultdadoBusca = pessoaFacade.getSituacaoPessoa(cpf);
        System.out.println(resultdadoBusca);
    }


    private static void avancarSituacaoPessoa(Scanner sc) {
        System.out.println("Digite o cpf");
        String cpf = sc.nextLine();
        String resultdadoBusca = pessoaFacade.avancarSituacao(cpf);
        System.out.println(resultdadoBusca);
    }
}
