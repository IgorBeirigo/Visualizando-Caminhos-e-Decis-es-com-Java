package estruturas;

public class ArvoreBinaria {
    private NoBST raiz;

    public void inserir(String caminho) {
        raiz = inserirRec(raiz, caminho);
    }

    private NoBST inserirRec(NoBST no, String caminho) {
        if (no == null) return new NoBST(caminho);

        int comparacao = caminho.compareTo(no.caminho);
        if (comparacao < 0) no.esquerda = inserirRec(no.esquerda, caminho);
        else if (comparacao > 0) no.direita = inserirRec(no.direita, caminho);

        return no;
    }

    public void exibirHistorico() {
        exibirHistoricoRec(raiz);
    }

    private void exibirHistoricoRec(NoBST no) {
        if (no != null) {
            exibirHistoricoRec(no.esquerda);
            System.out.println(no.caminho);
            exibirHistoricoRec(no.direita);
        }
    }
}
