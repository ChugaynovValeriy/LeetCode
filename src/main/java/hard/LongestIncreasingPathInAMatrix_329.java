package hard;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

public class LongestIncreasingPathInAMatrix_329 {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] resMatrix = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, maxWay(i, j, matrix, resMatrix));
            }
        }
        return max;
    }

    public int maxWay(int i, int j, int[][] matrix, int[][] resMatrix) {
        if (resMatrix[i][j] != 0) {
            return resMatrix[i][j];
        }

        if (i > 0 && matrix[i][j] > matrix[i - 1][j]) {
            resMatrix[i][j] = Math.max(resMatrix[i][j], maxWay(i - 1, j, matrix, resMatrix));
        }

        if (j > 0 && matrix[i][j] > matrix[i][j - 1]) {
            resMatrix[i][j] = Math.max(resMatrix[i][j], maxWay(i, j - 1, matrix, resMatrix));
        }

        int n = matrix.length;
        int m = matrix[0].length;

        if (i < n - 1 && matrix[i][j] > matrix[i + 1][j]) {
            resMatrix[i][j] = Math.max(resMatrix[i][j], maxWay(i + 1, j, matrix, resMatrix));
        }

        if (j < m - 1 && matrix[i][j] > matrix[i][j + 1]) {
            resMatrix[i][j] = Math.max(resMatrix[i][j], maxWay(i, j + 1, matrix, resMatrix));
        }

        return ++resMatrix[i][j];
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix_329 x = new LongestIncreasingPathInAMatrix_329();
        int[][] matrix = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(x.longestIncreasingPath(matrix));
    }
}
