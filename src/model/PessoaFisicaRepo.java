package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo implements Serializable {
    private List<PessoaFisica> pessoas;

    public PessoaFisicaRepo() {
        this.pessoas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoa) {
        pessoas.add(pessoa);
    }

    public void alterar(PessoaFisica pessoaNova) {
        for (PessoaFisica pf : pessoas) {
            if (pf.getId() == pessoaNova.getId()) {
                pf.setNome(pessoaNova.getNome());
                pf.setCpf(pessoaNova.getCpf());
                pf.setIdade(pessoaNova.getIdade());
                return;
            }
        }
    }

    public void excluir(int id) {
        pessoas.removeIf(p -> p.getId() == id);
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pf : pessoas) {
            if (pf.getId() == id) {
                return pf;
            }
        }
        return null;
    }

    public List<PessoaFisica> obterTodos() {
        return pessoas;
    }

    public void persistir(String arquivo) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
        oos.writeObject(pessoas);
        oos.close();
    }

    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
        pessoas = (List<PessoaFisica>) ois.readObject();
        ois.close();
    }
}
