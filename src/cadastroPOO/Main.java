package cadastroPOO;

import model.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===============================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("===============================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (opcao) {
                case 1:
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica: ");
                    String tipo = scanner.nextLine().toUpperCase();
                    if (tipo.equals("F")) {
                        System.out.print("Digite o id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.println("Insira os dados...");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
                    } else if (tipo.equals("J")) {
                        System.out.print("Digite o id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.println("Insira os dados...");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();
                        repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                    }
                    break;
                case 2:
                    // Alterar Pessoa
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica: ");
                    tipo = scanner.nextLine().toUpperCase();
                    if (tipo.equals("F")) {
                        System.out.print("Digite o id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        PessoaFisica pf = repoFisica.obter(id);
                        if (pf != null) {
                            System.out.println("Dados atuais: ");
                            pf.exibir();
                            System.out.println("Insira os novos dados...");
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("CPF: ");
                            String cpf = scanner.nextLine();
                            System.out.print("Idade: ");
                            int idade = scanner.nextInt();
                            repoFisica.alterar(new PessoaFisica(id, nome, cpf, idade));
                        } else {
                            System.out.println("Pessoa não encontrada.");
                        }
                    } else if (tipo.equals("J")) {
                        System.out.print("Digite o id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        PessoaJuridica pj = repoJuridica.obter(id);
                        if (pj != null) {
                            System.out.println("Dados atuais: ");
                            pj.exibir();
                            System.out.println("Insira os novos dados...");
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("CNPJ: ");
                            String cnpj = scanner.nextLine();
                            repoJuridica.alterar(new PessoaJuridica(id, nome, cnpj));
                        } else {
                            System.out.println("Pessoa não encontrada.");
                        }
                    }
                    break;
                case 3:
                    // Excluir Pessoa
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica: ");
                    tipo = scanner.nextLine().toUpperCase();
                    if (tipo.equals("F")) {
                        System.out.print("Digite o id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        repoFisica.excluir(id);
                    } else if (tipo.equals("J")) {
                        System.out.print("Digite o id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        repoJuridica.excluir(id);
                    }
                    break;
                case 4:
                    // Buscar pelo Id
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica: ");
                    tipo = scanner.nextLine().toUpperCase();
                    if (tipo.equals("F")) {
                        System.out.print("Digite o id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        PessoaFisica pf = repoFisica.obter(id);
                        if (pf != null) {
                            pf.exibir();
                        } else {
                            System.out.println("Pessoa não encontrada.");
                        }
                    } else if (tipo.equals("J")) {
                        System.out.print("Digite o id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        PessoaJuridica pj = repoJuridica.obter(id);
                        if (pj != null) {
                            pj.exibir();
                        } else {
                            System.out.println("Pessoa não encontrada.");
                        }
                    }
                    break;
                case 5:
                    // Exibir Todos
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica: ");
                    tipo = scanner.nextLine().toUpperCase();
                    if (tipo.equals("F")) {
                        List<PessoaFisica> todasFisicas = repoFisica.obterTodos();
                        todasFisicas.forEach(PessoaFisica::exibir);
                    } else if (tipo.equals("J")) {
                        List<PessoaJuridica> todasJuridicas = repoJuridica.obterTodos();
                        todasJuridicas.forEach(PessoaJuridica::exibir);
                    }
                    break;
                case 6:
                    // Persistir Dados
                    System.out.print("Digite o prefixo dos arquivos: ");
                    String prefixoSalvar = scanner.nextLine();
                    try {
                        repoFisica.persistir(prefixoSalvar + ".fisica.bin");
                        repoJuridica.persistir(prefixoSalvar + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;
                case 7:
                    // Recuperar Dados
                    System.out.print("Digite o prefixo dos arquivos: ");
                    String prefixoRecuperar = scanner.nextLine();
                    try {
                        repoFisica.recuperar(prefixoRecuperar + ".fisica.bin");
                        repoJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;
                case 0:
                    // Finalizar Programa
                    System.out.println("Finalizando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
