
package io.github.heullerramos.poo2024.PasseioCavaloComHeuristica;

/**
 *
 * @author heull
 */
public class PasseioCavaloComHeuristica {
    private final int N = 8;
    private int currentRow;
    private int currentColumn;
    private int[][] board;
    private int[][] accessibility;
    private final int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] vertical = {1, 2, 2, 1, -1, -2, -2, -1};

    public PasseioCavaloComHeuristica(int x,int y) {
        this.currentRow = x;
        this.currentColumn = y;
        this.board = new int[N][N];
        this.accessibility = new int[][] {
            {2, 3, 4, 4, 4, 4, 3, 2},
            {3, 4, 6, 6, 6, 6, 4, 3},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {3, 4, 6, 6, 6, 6, 4, 3},
            {2, 3, 4, 4, 4, 4, 3, 2}
        };
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }
    }
    //verifica se aposiçãi é válida
    private boolean isValido(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == 0);
    }
    //Atualiza a acessibilidade caso aquela casa seja acessada
    private void atualizarAcessibilidade(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int newX = x + vertical[i];
            int newY = y + horizontal[i];
            if (isValido(newX, newY)) {
                accessibility[newX][newY]--;
            }
        }
    }

    private boolean resolver(int x, int y, int moveCount) {
        board[x][y] = moveCount; // Marque a posição atual com o contador de movimentos
        atualizarAcessibilidade(x, y);

        if (moveCount == N * N) {
            return true; // Todos os quadrados foram visitados
        }

        // Array para armazenar os próximos movimentos possíveis e suas acessibilidades
        int[][] movimentos = new int[8][3]; // [indice do movimento, nextX, nextY]
        int[] acessibilidades = new int[8]; // Array para armazenar as acessibilidades

        for (int i = 0; i < 8; i++) {
            int nextX = x + vertical[i];
            int nextY = y + horizontal[i];
            //inserindo os valres no Array de movimentos {i,cordx,cordy}
            movimentos[i][0] = i; // Índice do movimento
            movimentos[i][1] = nextX; // Coordenada X
            movimentos[i][2] = nextY; // Coordenada Y
            if (isValido(nextX, nextY)) {
                //caso movimento seja valido armazena a acessibilidade dele
                acessibilidades[i] = accessibility[nextX][nextY];
            } else {
                acessibilidades[i] = Integer.MAX_VALUE; // Movimento inválido
            }
        }
        // Tentar os movimentos na ordem da heurística
        for (int i = 0; i < 8; i++) {
            int nextX = movimentos[i][1];
            int nextY = movimentos[i][2];
            if (isValido(nextX, nextY)) {
                if (resolver(nextX, nextY, moveCount + 1)) { 
                    return true; 
                }
            }
        }
        board[x][y] = 0; //desmarca a posição atual
        atualizarAcessibilidade(x, y); // Reverte a atualização da acessibilidade
        return false; 
    }

    public void iniciarPasseio() {
        if (resolver(currentRow, currentColumn, 1)) {
            // Exibe o tabuleiro
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%2d ", board[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Nenhuma solução encontrada.");
        }
    }

    
}
