package cadastroPoo;

import model.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Testando repositório de PessoaFisica
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(1, "João", "123.456.789-00", 30));
            repo1.inserir(new PessoaFisica(2, "Maria", "987.654.321-00", 25));
            
            System.out.println("Dados de Pessoa Fisica Armazenados.");

            repo1.persistir("pessoasFisicas.dat");
            
            System.out.println("Dados de Pessoa Fisica Recuperados.");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoasFisicas.dat");
            List<PessoaFisica> pessoasFisicas = repo2.obterTodos();
            for (PessoaFisica pf : pessoasFisicas) {
                pf.exibir();
            }

            // Testando repositório de PessoaJuridica
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(1, "Empresa A", "12.345.678/0001-99"));
            repo3.inserir(new PessoaJuridica(2, "Empresa B", "98.765.432/0001-11"));
            
            System.out.println("Dados de Pessoa Juridica Armazenados.");

            repo3.persistir("pessoasJuridicas.dat");
            
            System.out.println("Dados de Pessoa Juridica Recuperados.");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoasJuridicas.dat");
            List<PessoaJuridica> pessoasJuridicas = repo4.obterTodos();
            for (PessoaJuridica pj : pessoasJuridicas) {
                pj.exibir();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}