package medium;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int jPrev = -1;
        for (int i = 0; i < s.length(); i++) {
            jPrev = Math.max(map.get(s.charAt(i)) == null ? -1 : map.get(s.charAt(i)), jPrev);
            map.put(s.charAt(i), i);
            max = Math.max(max, i - jPrev);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 x = new LongestSubstringWithoutRepeatingCharacters_3();
        System.out.println(x.lengthOfLongestSubstring("a") == 1);
    }
}
