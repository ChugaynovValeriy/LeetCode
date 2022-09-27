package medium;

// https://leetcode.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[r] < 0) {
                    break;
                }
                int res = nums[i] + nums[l] + nums[r];
                if (res > 0) {
                    r--;
                } else if (res < 0) {
                    l++;
                } else {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    int lPlus = l + 1;
                    while (lPlus <= r && nums[l] == nums[lPlus]) {
                        l = lPlus;
                        lPlus++;
                    }
                    int rMinus = r - 1;
                    while (rMinus >= l && nums[r] == nums[rMinus]) {
                        r = rMinus;
                        rMinus--;
                    }
                    r = rMinus;
                    l = lPlus;
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum_15 x = new ThreeSum_15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(x.threeSum(nums));
    }
}
