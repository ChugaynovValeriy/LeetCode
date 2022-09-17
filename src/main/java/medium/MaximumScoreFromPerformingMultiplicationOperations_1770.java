package medium;

// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

public class MaximumScoreFromPerformingMultiplicationOperations_1770 {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;

        int[][] maxSums = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m - i; j++) {
                int sum1 = multipliers[m - i - 1] * nums[n - m + i + j];
                int sum2 = multipliers[m - i - 1] * nums[j];
                maxSums[j][i + j] = i == 0 ?
                        Math.max(sum1, sum2) :
                        Math.max(sum1 + maxSums[j][i + j - 1], sum2 + maxSums[j + 1][i + j]);
            }
        }

        return maxSums[0][m - 1];
    }

    public static void main(String[] args) {
        MaximumScoreFromPerformingMultiplicationOperations_1770 x = new MaximumScoreFromPerformingMultiplicationOperations_1770();
        int[] nums = new int[]{1,2,3};
        int[] multipliers = new int[]{3,2,1};
        System.out.println(x.maximumScore(nums, multipliers));
    }
}
