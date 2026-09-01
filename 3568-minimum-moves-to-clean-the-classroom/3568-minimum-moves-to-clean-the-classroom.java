class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] idx = new int[m][n];
        int sr = 0, sc = 0, count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    idx[i][j] = count++;
                }
            }
        }

        if (count == 0) return 0;

        int masks = 1 << count;
        int fullMask = masks - 1;

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][masks];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr, sc, energy, fullMask});
        visited[sr][sc][energy][fullMask] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];

                if (mask == 0) return moves;
                if (e == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;

                    char ch = classroom[nr].charAt(nc);

                    if (ch == 'X')
                        continue;

                    int ne = e - 1;
                    int nm = mask;

                    if (ch == 'R')
                        ne = energy;

                    if (ch == 'L')
                        nm &= ~(1 << idx[nr][nc]);

                    if (visited[nr][nc][ne][nm])
                        continue;

                    visited[nr][nc][ne][nm] = true;
                    q.offer(new int[]{nr, nc, ne, nm});
                }
            }

            moves++;
        }

        return -1;
    }
}