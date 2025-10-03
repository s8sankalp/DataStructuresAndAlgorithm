import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class distinct_islands {
    public void dfs(int row, int col, int[][] grid, boolean[][] vis, ArrayList<String> ans, int row0, int col0) {
        vis[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        ans.add(coord(row - row0, col - col0));
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, grid, vis, ans, row0, col0);
            }
        }
    }

    public String coord(int r, int c) {
        return r + " " + c;
    }

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<ArrayList<String>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<String> ans = new ArrayList<>();
                    dfs(i, j, grid, vis, ans, i, j);
                    st.add(ans);
                }
            }
        }
        return st.size();
    }

    // ----------------- MAIN METHOD -----------------
    public static void main(String[] args) {
        distinct_islands obj = new distinct_islands();

        int[][] grid = {
            {1, 1, 0, 0},
            {1, 0, 0, 1},
            {0, 0, 1, 1},
            {0, 0, 0, 0}
        };

        int distinct = obj.countDistinctIslands(grid);
        System.out.println("Number of distinct islands = " + distinct);
    }
}
