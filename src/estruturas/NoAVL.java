package estruturas;

public class NoAVL {
    String cidade;
    NoAVL esquerda, direita;
    int altura;

    public NoAVL(String cidade) {
        this.cidade = cidade;
        this.altura = 1;
    }
}
