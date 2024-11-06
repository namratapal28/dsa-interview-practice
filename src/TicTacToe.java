public class TicTacToe {
    char[][] grid;
    Player currPlayer;
    static boolean hasSomeoneWon = false;

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.startGame();

        while(!ticTacToe.isGameOver()) {
            ticTacToe.currPlayer = new Player('0');
            ticTacToe.currPlayer.makeMove(ticTacToe.grid);
            ticTacToe.printBoard();

            if(!ticTacToe.isGameOver()) {
                ticTacToe.currPlayer = new Player('X');
                ticTacToe.currPlayer.makeMove(ticTacToe.grid);
                ticTacToe.printBoard();
            }
        }
    }

    public void startGame() {
        grid = new char[3][3];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '-';
            }
        }

        currPlayer = new Player('0');
    }

    public boolean isGameOver() {
        if(hasSomeoneWon)
            return true;

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '-')
                    return false;
            }
        }

        return true;
    }

    public void printBoard() {
        for(int i = 0; i < grid.length; i++) {
            System.out.println();

            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}

class Player {
    char p;
    char otherPlayer;

    public Player(char p) {
        this.p = p;
        if(p == 'X')
            otherPlayer = '0';
        else
            otherPlayer = 'X';
    }

    public void makeMove(char[][] grid) {
        boolean madeMove = false;

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '-') {
                    // Block other player
                    grid[i][j] = otherPlayer;
                    if (isWinningMove(grid, otherPlayer)) {
                        grid[i][j] = p;
                        madeMove = true;
                        break;
                    } else
                        grid[i][j] = '-';
                }
            }

            if(madeMove)
                break;
        }

        if(!madeMove) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j] == '-') {
                        // Make winning move
                        grid[i][j] = p;
                        if (isWinningMove(grid, p)) {
                            TicTacToe.hasSomeoneWon = true;
                            madeMove = true;
                            break;
                        } else
                            grid[i][j] = '-';
                    }
                }

                if (madeMove)
                    break;
            }
        }

        // Make random move
        if(!madeMove) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '-') {
                        grid[i][j] = p;
                        madeMove = true;
                        break;
                    }
                }

                if(madeMove)
                    break;
            }
        }
    }

    public boolean isWinningMove(char[][] grid, char currPlayer) {
        for(int i = 0; i < grid.length; i++) {
            if(grid[i][0] == currPlayer && grid[i][1] == currPlayer && grid[i][2] == currPlayer)
                return true;
        }

        for(int i = 0; i < grid.length; i++) {
            if(grid[0][i] == currPlayer && grid[1][i] == currPlayer && grid[2][i] == currPlayer)
                return true;
        }

        return false;
    }
}
