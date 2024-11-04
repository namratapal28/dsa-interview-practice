public class NumberOfIslands {
    int res = 0;

    public static void main(String[] args) {
        // Test case 1
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        // Test case 2
        // char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println("Number of islands = " + numberOfIslands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    traverse(grid, i, j);
                }
            }
        }

        return res;
    }

    public void traverse(char[][] grid, int i, int j) {
        if(i - 1 >= 0 && j < grid[i].length && grid[i - 1][j] == '1') {
            grid[i - 1][j] = '0';
            traverse(grid, i - 1, j);
        }

        if(i + 1 < grid.length && j < grid[i].length && grid[i + 1][j] == '1') {
            grid[i + 1][j] = '0';
            traverse(grid, i + 1, j);
        }

        if(i < grid.length && j + 1 < grid[i].length && grid[i][j + 1] == '1') {
            grid[i][j + 1] = '0';
            traverse(grid, i, j + 1);
        }

        if(i < grid.length && j - 1 >= 0 && grid[i][j - 1] == '1') {
            grid[i][j - 1] = '0';
            traverse(grid, i, j - 1);
        }
    }
}
