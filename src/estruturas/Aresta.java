package estruturas;

public class Aresta {
    private Vertice destino;
    private double peso;

    public Aresta(Vertice destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getDestino() { return destino; }
    public double getPeso() { return peso; }
}
