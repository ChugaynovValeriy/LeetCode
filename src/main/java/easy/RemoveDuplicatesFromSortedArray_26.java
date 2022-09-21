package easy;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int prevIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (prev != nums[i]) {
                prevIndex++;
                int temp = nums[i];
                nums[i] = 0;
                nums[prevIndex] = temp;
                prev = temp;
            }
            else {
                nums[i] = 0;
            }
        }
        return prevIndex + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray_26 x = new RemoveDuplicatesFromSortedArray_26();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(x.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
