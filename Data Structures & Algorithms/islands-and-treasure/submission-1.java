class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] dirs = {{+1,0}, {-1,0}, {0,-1}, {0,+1}};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for(int i = 0; i < 4 ; i++){
                int newRow = row+dirs[i][0];
                int newCol = col+dirs[i][1];
                if(newRow < n && newRow >= 0 && newCol < m && newCol >= 0 && grid[newRow][newCol] == Integer.MAX_VALUE){
                    grid[newRow][newCol] = grid[row][col] + 1;
                    queue.offer(new int[]{newRow , newCol});
                }
            }
        }
    }
}
