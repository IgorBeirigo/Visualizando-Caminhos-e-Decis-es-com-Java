package estruturas;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Grafo grafo = new Grafo();
    private static ArvoreAVL avl = new ArvoreAVL();
    private static ArvoreBinaria historico = new ArvoreBinaria();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    adicionarCidade();
                    break;
                case 2:
                    conectarCidades();
                    break;
                case 3:
                    exibirCidades();
                    break;
                case 4:
                    calcularMenorCaminho();
                    break;
                case 5:
                    verHistorico();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1- Adicionar cidade");
        System.out.println("2- Conectar cidades");
        System.out.println("3- Ver todas as cidades");
        System.out.println("4- Calcular menor caminho");
        System.out.println("5- Ver histórico de caminhos");
        System.out.println("6- Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarCidade() {
        System.out.print("Nome da cidade: ");
        String cidade = scanner.nextLine();
        grafo.adicionarVertice(cidade);
        avl.inserir(cidade);
        System.out.println("Cidade adicionada com sucesso!");
    }

    private static void conectarCidades() {
        System.out.print("Cidade de origem: ");
        String origem = scanner.nextLine();
        System.out.print("Cidade de destino: ");
        String destino = scanner.nextLine();
        System.out.print("Distância: ");
        double distancia = scanner.nextDouble();
        
        grafo.conectarCidades(origem, destino, distancia);
        System.out.println("Cidades conectadas com sucesso!");
    }

    private static void exibirCidades() {
        System.out.println("\nCidades em ordem alfabética:");
        avl.exibirEmOrdem();
    }

    private static void calcularMenorCaminho() {
        System.out.print("Cidade de origem: ");
        String origem = scanner.nextLine();
        System.out.print("Cidade de destino: ");
        String destino = scanner.nextLine();

        List<String> caminho = grafo.calcularMenorCaminho(origem, destino);
        String resultado = String.join(" -> ", caminho);
        System.out.println("Menor caminho: " + resultado);
        historico.inserir(resultado);
    }

    private static void verHistorico() {
        System.out.println("\nHistórico de caminhos:");
        historico.exibirHistorico();
    }
}
