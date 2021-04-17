package situacao_pessoa;

public class SituacaoFactory {
    private SituacaoFactory() {
    }

    public static Situacao factorySituacao(int situacaoNumber) {
        if (situacaoNumber == 1) {
            return new NaoHabilitado();
        }

        if (situacaoNumber == 2) {
            return new Dose1();
        }

        if (situacaoNumber == 3) {
            new TomouDose1();
        }

        if (situacaoNumber == 4) {
            return new Dose2();
        }

        if (situacaoNumber == 5) {
            return new FinalizadaVacinacao();
        }

        return null;
    }

}
