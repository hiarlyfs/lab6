package situacao_pessoa;

import entidade.Pessoa;

public class FinalizadaVacinacao implements Situacao{
    private static final String SITUACAO_ATUAL = "Finalizada vacinacao";

    public FinalizadaVacinacao() {
    }



    @Override
    public void proximaSituacao(Pessoa pessoa) {
    }

    @Override
    public String getSituacao() {
        return this.SITUACAO_ATUAL;
    }
}
