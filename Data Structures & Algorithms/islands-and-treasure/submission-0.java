class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 0){
                    dfs(grid,i,j,0);
                }
            }
        }
    }
    private void dfs(int[][] grid , int row , int col, int dist){
        int n  = grid.length;
        int m = grid[0].length;
        if(row >= n || col >= m || row < 0 || col < 0 || grid[row][col] == -1 || grid[row][col] < dist){
            return ;
        }
        grid[row][col] = dist;
        dfs(grid, row + 1, col, dist + 1);
        dfs(grid, row - 1, col, dist + 1);
        dfs(grid, row, col + 1, dist + 1);
        dfs(grid, row, col - 1, dist + 1);
    }
}
