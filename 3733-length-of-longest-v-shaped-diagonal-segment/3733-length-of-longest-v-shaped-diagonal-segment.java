class Solution {
    private int[][] dirs = {{1,1}, {1,-1}, {-1,-1}, {-1,1}}; // ↘️ ↙️ ↖️ ↗️
    private int n, m;
    private int[][] grid;
    private Integer[][][][] dp; // dp[r][c][dir][turnUsed]

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m][4][2];

        int ans = 0;

        // start only from cells with '1'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        ans = Math.max(ans, 1 + dfs(i, j, d, 0, 2, 0));
                    }
                }
            }
        }

        return ans;
    }

    // DFS with memoization
    private int dfs(int r, int c, int dir, int turnUsed, int expected, int length) {
        if (dp[r][c][dir][turnUsed] != null) return dp[r][c][dir][turnUsed];

        int best = 0;

        // continue straight
        int nr = r + dirs[dir][0], nc = c + dirs[dir][1];
        if (valid(nr, nc) && grid[nr][nc] == expected) {
            best = Math.max(best, 1 + dfs(nr, nc, dir, turnUsed, next(expected), length + 1));
        }

        // try clockwise turn if not used yet
        if (turnUsed == 0) {
            int newDir = (dir + 1) % 4; // clockwise turn
            int nr2 = r + dirs[newDir][0], nc2 = c + dirs[newDir][1];
            if (valid(nr2, nc2) && grid[nr2][nc2] == expected) {
                best = Math.max(best, 1 + dfs(nr2, nc2, newDir, 1, next(expected), length + 1));
            }
        }

        return dp[r][c][dir][turnUsed] = best;
    }

    private boolean valid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    private int next(int x) {
        if (x == 2) return 0;
        if (x == 0) return 2;
        return 2; // never used (1 is only start)
    }
}