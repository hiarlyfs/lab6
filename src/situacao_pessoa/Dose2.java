package situacao_pessoa;

import entidade.Pessoa;

public class Dose2 implements Situacao{
    private static final String SITUACAO_ATUAL = "HABILIDATE PARA TOMAR A 2 DOSE";


    @Override
    public void proximaSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new FinalizadaVacinacao());
    }

    @Override
    public String getSituacao() {
        return this.SITUACAO_ATUAL;
    }
}
