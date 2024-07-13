package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo implements Serializable {
    private List<PessoaJuridica> pessoas;

    public PessoaJuridicaRepo() {
        this.pessoas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoa) {
        pessoas.add(pessoa);
    }

    public void alterar(PessoaJuridica pessoaNova) {
        for (PessoaJuridica pj : pessoas) {
            if (pj.getId() == pessoaNova.getId()) {
                pj.setNome(pessoaNova.getNome());
                pj.setCnpj(pessoaNova.getCnpj());
                return;
            }
        }
    }

    public void excluir(int id) {
        pessoas.removeIf(p -> p.getId() == id);
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pj : pessoas) {
            if (pj.getId() == id) {
                return pj;
            }
        }
        return null;
    }

    public List<PessoaJuridica> obterTodos() {
        return pessoas;
    }

    public void persistir(String arquivo) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
        oos.writeObject(pessoas);
        oos.close();
    }

    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
        pessoas = (List<PessoaJuridica>) ois.readObject();
        ois.close();
    }
}
