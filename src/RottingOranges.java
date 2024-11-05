public class RottingOranges {
    int res = 0;

    public static void main(String[] args) {
        RottingOranges obj = new RottingOranges();
        // Test case 1
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        // Test case 2
        // int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        // Test case 3
        // int[][] grid = {{0,2}};

        System.out.println("Minimum time needed to rot all oranges = "+obj.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    calc(grid, i, j, 0);
                }
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }

        return res;
    }

    public void calc(int[][] grid, int i, int j, int cnt) {
        if((j + 1 < grid[i].length && grid[i][j + 1] == 1 && i == grid.length - 1 && j + 1 == grid[i].length - 1) || (j - 1 >= 0 && grid[i][j - 1] == 1 && i == grid.length - 1 && j - 1 == grid[i].length - 1) || (i - 1 >= 0 && grid[i - 1][j] == 1) || (i + 1 < grid.length && grid[i + 1][j] == 1 && i + 1 == grid.length - 1 && j == grid[i].length - 1)) {
            cnt = cnt + 1;
            res = cnt;
        }

        if((j + 1 < grid[i].length && grid[i][j + 1] == 1) || (j - 1 >= 0 && grid[i][j - 1] == 1) || (i - 1 >= 0 && grid[i - 1][j] == 1) || (i + 1 < grid.length && grid[i + 1][j] == 1)) {
            cnt = cnt + 1;

            if(j + 1 < grid[i].length && grid[i][j + 1] == 1) {
                grid[i][j + 1] = 2;
                calc(grid, i, j + 1, cnt);
            }

            if(j - 1 >= 0 && grid[i][j - 1] == 1) {
                grid[i][j - 1] = 2;
                calc(grid, i, j - 1, cnt);
            }

            if(i - 1 >= 0 && grid[i - 1][j] == 1) {
                grid[i - 1][j] = 2;
                calc(grid, i - 1, j, cnt);
            }

            if(i + 1 < grid.length && grid[i + 1][j] == 1) {
                grid[i + 1][j] = 2;
                calc(grid, i + 1, j, cnt);
            }
        }
    }
}
