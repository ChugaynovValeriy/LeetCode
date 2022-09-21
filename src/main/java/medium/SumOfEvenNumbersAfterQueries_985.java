package medium;

// https://leetcode.com/problems/sum-of-even-numbers-after-queries/

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries_985 {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int evenSum = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (nums[queries[i][1]] % 2 == 0) {
                if (queries[i][0] % 2 == 0) {
                    evenSum += queries[i][0];
                } else {
                    evenSum -= nums[queries[i][1]];
                }
            } else if (queries[i][0] % 2 != 0) {
                evenSum += (nums[queries[i][1]] + queries[i][0]);
            }
            nums[queries[i][1]] += queries[i][0];
            res[i] = evenSum;
        }
        return res;
    }


    public static void main(String[] args) {
        SumOfEvenNumbersAfterQueries_985 x = new SumOfEvenNumbersAfterQueries_985();
        int[] nums = new int[]{1, 2, 3, 4};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        int[] res = x.sumEvenAfterQueries(nums, queries);
        System.out.println(Arrays.toString(res));
    }
}
