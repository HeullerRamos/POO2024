
package io.github.heullerramos.poo2024.PasseioCavaloSemHeuristica;

/**
 *
 * @author heull
 */
public class PasseioCavalo {
    private int currentColumn;
    private int currentRow;;
    private final int N=8;
    private int[][] tabuleiro;
    private final int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] vertical = {1, 2, 2, 1, -1, -2, -2, -1};

    public PasseioCavalo(int x,int y) {
        this.currentColumn=y;
        this.currentRow=x;
        this.tabuleiro = new int[N][N];
        inicializarTabuleiro();
    }
    //inicia  tabuleiro com todas as posições zeradas
    private void inicializarTabuleiro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tabuleiro[i][j] = 0;
            }
        }
    }
    //verifica se a posição é válida(diferente de zero ou está dentro do tabuleiro)
    private boolean isValido(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && tabuleiro[x][y] == 0);
    }

    private boolean resolver(int currentRow,int currentColumn,int moveCount) {
        tabuleiro[currentRow][currentColumn] = moveCount; // Marque a posição atual com o contador de movimentos

        if (moveCount == N * N) {
            return true; // Todos os quadrados foram visitados
        }

        // Tentar todos os 8 movimentos possíveis do cavalo
        for (int i = 0; i < 8; i++) {
            int nexty = currentColumn + vertical[i];
            int nextx = currentRow + horizontal[i];
            if (isValido(nextx,nexty)) {
                if (resolver(nextx,nexty,moveCount + 1)) { // Move o cavalo para a próxima posição
                    return true; // Se a recursão retornar verdadeiro, a solução foi encontrada
                }
            }
        }

        tabuleiro[currentRow][currentColumn] = 0; // Backtracking: desmarca a posição atual
        return false; // Retorna falso se nenhum movimento levar a uma solução
    }

    public void iniciarPasseio() {
        if (resolver(currentRow,currentColumn,1)) {
            // Exibe o tabuleiro
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%2d ", tabuleiro[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Nenhuma solução encontrada.");
        }
    }

   
}

