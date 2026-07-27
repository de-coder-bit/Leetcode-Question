class Solution {
    private int[][] dp;
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0)
            return dp[i][j];

        int max = 1;

        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < matrix.length &&
                y >= 0 && y < matrix[0].length &&
                matrix[x][y] > matrix[i][j]) {

                max = Math.max(max, 1 + dfs(matrix, x, y));
            }
        }

        dp[i][j] = max;
        return max;
    }
}