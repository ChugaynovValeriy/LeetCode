package hard;

// https://leetcode.com/problems/first-missing-positive/

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int currentByAbs = Math.abs(nums[i]);
            if (currentByAbs <= nums.length && currentByAbs > 0) {
                if (nums[currentByAbs - 1] == 0) {
                    nums[currentByAbs - 1] = -currentByAbs;
                } else {
                    nums[currentByAbs - 1] = -Math.abs(nums[currentByAbs - 1]);
                }
            }
        }
        int i = 0;
        while (i < nums.length && nums[i] < 0) {
            i++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive_41 x = new FirstMissingPositive_41();
        int[] nums1 = new int[]{2, 3, 4, 5, 6, 7, 8};
        int[] nums2 = new int[]{1};
        int[] nums3 = new int[]{3, 4, -1, 1};
        int[] nums4 = new int[]{0, 1, 2};
        System.out.println(x.firstMissingPositive(nums1));
        System.out.println(x.firstMissingPositive(nums2));
        System.out.println(x.firstMissingPositive(nums3));
        System.out.println(x.firstMissingPositive(nums4));
    }
}
