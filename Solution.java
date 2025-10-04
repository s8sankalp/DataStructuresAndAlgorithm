public class Solution {
    public void dfs(int row,int col,int[] delrow,int[] delcol,int[][] image,int[][] ans,int intial,int newColor)
    {
        ans[row][col]=newColor;
        int n=ans.length;
        int m=ans[0].length;
        for(int i=0;i<4;i++)
        {
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            if(newrow>=0&&newrow<n&&newcol>=0&&newcol<m&&image[newrow][newcol]==intial&&ans[newrow][newcol]!=newColor)
            {
                dfs(newrow,newcol,delrow,delcol,image,ans,intial,newColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int initial = image[sr][sc];
    int n = image.length;
    int m = image[0].length;
    int[][] ans = new int[n][m];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            ans[i][j] = image[i][j];
        }
    }
    int[] delrow = {-1, 0, 1, 0};
    int[] delcol = {0, 1, 0, -1};
    dfs(sr, sc, delrow, delcol, image, ans, initial, newColor);
    return ans;
}
     public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1;
        int newColor = 2;
        
        // Creating an instance of Solution class
        Solution sol = new Solution();
        
        // Function call to find the number of islands in given grid
        int[][] ans = sol.floodFill(image, sr, sc, newColor);
        
        System.out.println("Image after performing flood fill algorithm:\n");
        
        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
