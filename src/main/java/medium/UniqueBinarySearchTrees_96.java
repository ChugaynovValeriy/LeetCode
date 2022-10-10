package medium;

// https://leetcode.com/problems/unique-binary-search-trees/

public class UniqueBinarySearchTrees_96 {
    public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int l = 0;
            while (l < i) {
                result[i] += result[l] * result[i - l - 1];
                l++;
            }
        }
        return result[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees_96 x = new UniqueBinarySearchTrees_96();
        System.out.println(x.numTrees(300));
    }
}
