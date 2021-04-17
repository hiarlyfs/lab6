package dto;

import situacao_pessoa.Situacao;

import java.util.List;

public class PessoaDto {
    private String nomeCompleto;
    private String CPF;
    private String endereço;
    private String cartaoSus;
    private String email;
    private String telefone;
    private String profissao;
    private List<String> cormobidades;
    private int situacao;
    private int idade;

    public PessoaDto(String nomeCompleto, String CPF, int idade, String endereço, String cartaoSus, String email, String telefone, String profissao, List<String> cormobidades, int situacao) {
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.endereço = endereço;
        this.cartaoSus = cartaoSus;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        this.cormobidades = cormobidades;
        this.situacao = situacao;
        this.idade = idade;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEndereço() {
        return endereço;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public List<String> getCormobidades() {
        return cormobidades;
    }

    public int getSituacao() {
        return situacao;
    }

    public int getIdade() {
        return idade;
    }
}
