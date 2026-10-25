class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

       
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0)
                dfs(grid, vis, i, 0);

            if (grid[i][n - 1] == 0)
                dfs(grid, vis, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0)
                dfs(grid, vis, 0, j);

            if (grid[m - 1][j] == 0)
                dfs(grid, vis, m - 1, j);
        }

        int count = 0;

        // Count closed islands
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    count++;
                    dfs(grid, vis, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, boolean[][] vis, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n)
            return;

        if (grid[r][c] == 1 || vis[r][c])
            return;

        vis[r][c] = true;

        dfs(grid, vis, r - 1, c);
        dfs(grid, vis, r + 1, c);
        dfs(grid, vis, r, c - 1);
        dfs(grid, vis, r, c + 1);
    }
}