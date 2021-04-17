package situacao_pessoa;

import entidade.Pessoa;

public class Dose1 implements Situacao{
    private static final String SITUACAO_ATUAL = "Habilitada para tomar a 1 dose";

    public Dose1() {
    }


    @Override
    public void proximaSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new TomouDose1());
    }

    @Override
    public String getSituacao() {
        return this.SITUACAO_ATUAL;
    }
}
