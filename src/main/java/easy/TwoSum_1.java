package easy;

// https://leetcode.com/problems/two-sum

import java.util.Arrays;

public class TwoSum_1 {
    public int[] twoSum0(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum_1 x = new TwoSum_1();
        int[] nums = new int[]{2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(x.twoSum0(nums, 6)));
    }
}
