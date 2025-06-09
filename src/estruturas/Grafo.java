package estruturas;

import java.util.*;

public class Grafo {
    private Map<String, Vertice> vertices;

    public Grafo() {
        vertices = new HashMap<>();
    }

    public void adicionarVertice(String cidade) {
        vertices.putIfAbsent(cidade, new Vertice(cidade));
    }

    public void conectarCidades(String origem, String destino, double distancia) {
        Vertice verticeOrigem = vertices.get(origem);
        Vertice verticeDestino = vertices.get(destino);
        
        if (verticeOrigem != null && verticeDestino != null) {
            verticeOrigem.adicionarAresta(new Aresta(verticeDestino, distancia));
            verticeDestino.adicionarAresta(new Aresta(verticeOrigem, distancia));
        }
    }

    public List<String> calcularMenorCaminho(String origem, String destino) {
        // Implementação do algoritmo de Dijkstra
        PriorityQueue<Vertice> fila = new PriorityQueue<>(
            Comparator.comparingDouble(Vertice::getDistancia));
        
        vertices.values().forEach(v -> {
            v.setVisitado(false);
            v.setDistancia(Double.POSITIVE_INFINITY);
            v.setAnterior(null);
        });

        Vertice inicio = vertices.get(origem);
        inicio.setDistancia(0);
        fila.offer(inicio);

        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();
            if (atual.getCidade().equals(destino)) break;
            
            if (atual.isVisitado()) continue;
            atual.setVisitado(true);

            for (Aresta aresta : atual.getArestas()) {
                Vertice vizinho = aresta.getDestino();
                if (!vizinho.isVisitado()) {
                    double novaDistancia = atual.getDistancia() + aresta.getPeso();
                    if (novaDistancia < vizinho.getDistancia()) {
                        vizinho.setDistancia(novaDistancia);
                        vizinho.setAnterior(atual);
                        fila.offer(vizinho);
                    }
                }
            }
        }

        // Reconstrói o caminho
        List<String> caminho = new ArrayList<>();
        Vertice atual = vertices.get(destino);
        while (atual != null) {
            caminho.add(0, atual.getCidade());
            atual = atual.getAnterior();
        }
        return caminho;
    }

    public Set<String> getCidades() {
        return vertices.keySet();
    }
}
