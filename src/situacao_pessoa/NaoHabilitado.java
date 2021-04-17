package situacao_pessoa;

import entidade.Pessoa;

public class NaoHabilitado implements Situacao{
    private static final String SITUACAO_ATUAL = "Nao hailitado para vacina";

    public NaoHabilitado() {
    }

    @Override
    public void proximaSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new Dose1());
    }

    @Override
    public String getSituacao() {
        return this.SITUACAO_ATUAL;
    }
}
