package facade;

import dto.PessoaDto;
import service.PessoaService;

import java.util.List;

public class PessoaFacade {
    private PessoaService pessoaService;

    public PessoaFacade() {
        this.pessoaService = new PessoaService();
    }

    public String cadastrarPessoa(String nomeCompleto, String CPF, int idade,
             String endereço, String cartaoSus, String email,
             String telefone, String profissao, List<String>cormobidades, int situacao) {

        PessoaDto pessoaDto = new PessoaDto(nomeCompleto,  CPF, idade,
                endereço,  cartaoSus,  email, telefone,
                profissao, cormobidades, situacao);

        try {
            pessoaService.cadastrarPessoa(pessoaDto);
            return "Nova Pessoa cadastrada";
        } catch (IllegalAccessException e) {
            return "Já existe uma pessoa cadastrada com esse CPF";
        }
    }


    public String atualizarPessoa(String nomeCompleto, String CPF, int idade,
                                  String endereço, String cartaoSus, String email,
                                  String telefone, String profissao, List<String>cormobidades, int situacao) {

        PessoaDto pessoaDto = new PessoaDto(nomeCompleto,  CPF, idade,
                endereço,  cartaoSus,  email, telefone,
                profissao, cormobidades, situacao);

        try {
            pessoaService.atualizarPessoa(pessoaDto);
            return "Pessoa atualizada";
        } catch (IllegalAccessException e) {
            return "Não existe uma pessoa cadastrada com esse CPF";
        }
    }

    public String getPessoa(String cpf) {
        try {
            return pessoaService.getPessoa(cpf).toString();
        } catch (IllegalAccessException e) {
            return "Não existe uma pessoa cadastrada com esse CPF";
        }
    }

    public String getSituacaoPessoa(String cpf) {
        try {
            return pessoaService.getSituacaoPessoa(cpf);
        } catch (IllegalAccessException e) {
            return "Não existe uma pessoa cadastrada com esse CPF";
        }
    }

    public String avancarSituacao(String cpf) {
        try {
            return "Nova situacao: " + pessoaService.avancarSituacao(cpf);
        } catch (IllegalAccessException e) {
            return "Não existe uma pessoa cadastrada com esse CPF";
        }
    }
}
