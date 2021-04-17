package repositorio;

import entidade.Pessoa;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PessoaRepositorio {
    private Map<String, Pessoa> pessoaRepositorio = new HashMap<>();

    public void create(Pessoa novaPessoa) throws IllegalAccessException {
        Pessoa pessoaJaExistente = findByCpf(novaPessoa.getCpf());

        if (pessoaJaExistente != null) {
            throw new IllegalAccessException("Já existe alguem cadastrado com esse CPF");
        }

        pessoaRepositorio.put(novaPessoa.getCpf(), novaPessoa);
    }


    public Pessoa findByCpf(String cpf) {
        return this.pessoaRepositorio.get(cpf);
    }


    public void update(Pessoa pessoaAtualizada) throws IllegalAccessException {
        Pessoa pessoaJaExistente = findByCpf(pessoaAtualizada.getCpf());

        if (pessoaJaExistente == null) {
            throw new IllegalAccessException("Não existe ninguém cadastrado com esse CPF");
        }

        pessoaRepositorio.replace(pessoaAtualizada.getCpf(), pessoaAtualizada);
    }

    public Collection<Pessoa> getPessoas() {
        return pessoaRepositorio.values();
    }

}
