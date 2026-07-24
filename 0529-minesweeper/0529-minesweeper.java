class Solution {

    int[][] dir = {
        {-1,-1}, {-1,0}, {-1,1},
        {0,-1},          {0,1},
        {1,-1}, {1,0}, {1,1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {

        int r = click[0];
        int c = click[1];

        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        dfs(board, r, c);
        return board;
    }

    private void dfs(char[][] board, int r, int c) {

        int m = board.length;
        int n = board[0].length;

        int mines = 0;

        // Count adjacent mines
        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                board[nr][nc] == 'M') {

                mines++;
            }
        }

        if (mines > 0) {
            board[r][c] = (char)(mines + '0');
            return;
        }

        board[r][c] = 'B';

        // Explore neighbours
        for (int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                board[nr][nc] == 'E') {

                dfs(board, nr, nc);
            }
        }
    }
}