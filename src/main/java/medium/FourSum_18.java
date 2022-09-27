package medium;

// https://leetcode.com/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target / 4) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {

                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[r] < target / 4) {
                        break;
                    }
                    long res = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (res > target) {
                        r--;
                    } else if (res < target) {
                        l++;
                    } else {
                        result.add(List.of(nums[i], nums[j], nums[l], nums[r]));
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
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                    j++;
                }

            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum_18 x = new FourSum_18();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(x.fourSum(nums, 0));
        nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(x.fourSum(nums, -294967296));
    }
}
