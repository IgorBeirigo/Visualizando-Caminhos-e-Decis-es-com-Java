package estruturas;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String cidade;
    private List<Aresta> arestas;
    private boolean visitado;
    private double distancia;
    private Vertice anterior;

    public Vertice(String cidade) {
        this.cidade = cidade;
        this.arestas = new ArrayList<>();
        this.visitado = false;
        this.distancia = Double.POSITIVE_INFINITY;
        this.anterior = null;
    }

    // Getters e setters
    public String getCidade() { return cidade; }
    public List<Aresta> getArestas() { return arestas; }
    public boolean isVisitado() { return visitado; }
    public void setVisitado(boolean visitado) { this.visitado = visitado; }
    public double getDistancia() { return distancia; }
    public void setDistancia(double distancia) { this.distancia = distancia; }
    public Vertice getAnterior() { return anterior; }
    public void setAnterior(Vertice anterior) { this.anterior = anterior; }

    public void adicionarAresta(Aresta aresta) {
        arestas.add(aresta);
    }
}
