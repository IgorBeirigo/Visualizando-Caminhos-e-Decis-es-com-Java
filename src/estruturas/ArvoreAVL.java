package estruturas;

public class ArvoreAVL {
    private NoAVL raiz;

    private int altura(NoAVL no) {
        return no == null ? 0 : no.altura;
    }

    private int fatorBalanceamento(NoAVL no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public void inserir(String cidade) {
        raiz = inserirRec(raiz, cidade);
    }

    private NoAVL inserirRec(NoAVL no, String cidade) {
        if (no == null) return new NoAVL(cidade);

        int comparacao = cidade.compareTo(no.cidade);
        if (comparacao < 0) no.esquerda = inserirRec(no.esquerda, cidade);
        else if (comparacao > 0) no.direita = inserirRec(no.direita, cidade);
        else return no;

        no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
        int fb = fatorBalanceamento(no);

        // Casos de balanceamento
        if (fb > 1 && cidade.compareTo(no.esquerda.cidade) < 0)
            return rotacaoDireita(no);

        if (fb < -1 && cidade.compareTo(no.direita.cidade) > 0)
            return rotacaoEsquerda(no);

        if (fb > 1 && cidade.compareTo(no.esquerda.cidade) > 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (fb < -1 && cidade.compareTo(no.direita.cidade) < 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void exibirEmOrdem() {
        exibirEmOrdemRec(raiz);
    }

    private void exibirEmOrdemRec(NoAVL no) {
        if (no != null) {
            exibirEmOrdemRec(no.esquerda);
            System.out.println(no.cidade);
            exibirEmOrdemRec(no.direita);
        }
    }
}
