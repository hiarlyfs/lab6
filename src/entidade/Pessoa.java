package entidade;

import situacao_pessoa.NaoHabilitado;
import situacao_pessoa.Situacao;

import java.util.List;
import java.util.Objects;

public class Pessoa {

    private String nomeCompleto;
    private String CPF;
    private String endereço;
    private String cartaoSus;
    private String email;
    private String telefone;
    private String profissao;
    private List<String> cormobidades;
    private Situacao situacao;
    private int idade;

    public Pessoa(String nomeCompleto, String CPF, int idade, String endereço, String cartaoSus,
                  String email, String telefone, String profissao,
                  List<String> cormobidades, Situacao situacao) {
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


    public String getCpf() {
        return this.CPF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(CPF, pessoa.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPF);
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public String getSitucao() {
        return this.situacao.getSituacao();
    }

    public void avancarSituacao() {
        this.situacao.proximaSituacao(this);
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", CPF='" + CPF + '\'' +
                ", endereço='" + endereço + '\'' +
                ", cartaoSus='" + cartaoSus + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", profissao='" + profissao + '\'' +
                ", cormobidades=" + cormobidades +
                ", situacao=" + situacao +
                ", idade=" + idade +
                '}';
    }
}
