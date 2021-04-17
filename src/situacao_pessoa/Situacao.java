package situacao_pessoa;

import entidade.Pessoa;

public interface Situacao {
    public void proximaSituacao(Pessoa pessoa);
    public String getSituacao();
}
