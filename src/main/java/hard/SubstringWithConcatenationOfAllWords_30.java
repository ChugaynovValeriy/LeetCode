package hard;

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords_30 {

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, int[]> wordsMap = new HashMap<>();
        int uniqueCount = 0;
        for (String word : words) {
            int[] pair = wordsMap.get(word);
            if (pair == null) {
                wordsMap.put(word, new int[]{uniqueCount, 1});
                uniqueCount++;
            } else {
                pair[1]++;
            }
        }

        int[][] dynamicResult = new int[s.length()][wordsMap.size()];
        int length = words[0].length();
        int len = s.length() - length;
        for (int i = 0; i <= len; i++) {
            String temp = s.substring(i, i + length);
            int[] pair = wordsMap.get(temp);
            if (pair != null) {
                int limit = Math.max(i - words.length * length + 1, 0);
                for (int j = i; j >= limit; j -= length) {
                    dynamicResult[j][pair[0]]++;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < dynamicResult.length; i++) {
            boolean isFull = true;
            for (int[] pair : wordsMap.values()) {
                if (dynamicResult[i][pair[0]] != pair[1]) {
                    isFull = false;
                    break;
                }
            }
            if (isFull) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords_30 x = new SubstringWithConcatenationOfAllWords_30();
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        System.out.println(x.findSubstring(s, words));
        s = "wordgoodgoodgoodbestword";
        words = new String[]{"word", "good", "best", "good"};
        System.out.println(x.findSubstring(s, words));
        s = "aaabbbc";
        words = new String[]{"a", "a", "b", "b", "c"};
        System.out.println(x.findSubstring(s, words));
    }
}
