package service;

import dto.PessoaDto;
import entidade.Pessoa;
import repositorio.PessoaRepositorio;
import situacao_pessoa.Situacao;
import situacao_pessoa.SituacaoFactory;

import java.util.Collection;
import java.util.List;

public class PessoaService {
    private PessoaRepositorio pessoaRepositorio;

    public PessoaService() {
        this.pessoaRepositorio = new PessoaRepositorio();
    }

    public void cadastrarPessoa(PessoaDto pessoaDto) throws IllegalAccessException {
        Situacao situacao = SituacaoFactory.factorySituacao(pessoaDto.getSituacao());

        Pessoa novaPessoa = new Pessoa(pessoaDto.getNomeCompleto(), pessoaDto.getCPF(),
                pessoaDto.getIdade(), pessoaDto.getEndereço(), pessoaDto.getCartaoSus(),
                pessoaDto.getEmail(), pessoaDto.getTelefone(),
                pessoaDto.getProfissao(), pessoaDto.getCormobidades(), situacao);

        pessoaRepositorio.create(novaPessoa);
    }

    public void atualizarPessoa(PessoaDto pessoaDto) throws IllegalAccessException {
        Situacao situacao = SituacaoFactory.factorySituacao(pessoaDto.getSituacao());

        Pessoa pessoaAtualizada = new Pessoa(pessoaDto.getNomeCompleto(), pessoaDto.getCPF(),
                pessoaDto.getIdade(), pessoaDto.getEndereço(), pessoaDto.getCartaoSus(),
                pessoaDto.getEmail(), pessoaDto.getTelefone(),
                pessoaDto.getProfissao(), pessoaDto.getCormobidades(), situacao);

        pessoaRepositorio.update(pessoaAtualizada);
    }

    public Pessoa getPessoa(String cpf) throws IllegalAccessException {
        Pessoa pessoa = pessoaRepositorio.findByCpf(cpf);
        checkPessoa(pessoa);
        return pessoa;
    }


    public String getSituacaoPessoa(String cpf) throws IllegalAccessException {
        Pessoa pessoa = pessoaRepositorio.findByCpf(cpf);

        if (pessoa != null) {
            return pessoa.getSitucao();
        }

        throw new IllegalAccessException("Não existe ninguem com esse cpf");
    }

    public String avancarSituacao(String cpf) throws IllegalAccessException {
        Pessoa pessoa = pessoaRepositorio.findByCpf(cpf);
        checkPessoa(pessoa);
        pessoa.avancarSituacao();
        return pessoa.getSitucao();
    }


    private void checkPessoa(Pessoa pessoa) throws IllegalAccessException {
        if (pessoa == null) {
            throw new IllegalAccessException("Não existe ninguem com esse cpf");
        }
    }
}
