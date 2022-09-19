package medium;

// https://leetcode.com/problems/zigzag-conversion/

public class ZigzagConversion_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int i = 0;
        char[] res = new char[s.length()];
        int rowI = 1;
        while (i < s.length()) {
            int resIndex = rowI;
            while (resIndex <= res.length) {
                i++;
                res[i - 1] = s.charAt(resIndex - 1);
                if (rowI != 1 && rowI != numRows) {
                    int subResIndex = (resIndex + (numRows - rowI) * 2);
                    if (subResIndex <= res.length) {
                        i++;
                        res[i - 1] = s.charAt(subResIndex - 1);
                    }
                }
                resIndex += (2 * numRows - 2);
            }
            rowI++;
        }
        return String.copyValueOf(res);
    }

    public static void main(String[] args) {
        ZigzagConversion_6 x = new ZigzagConversion_6();
        System.out.println(x.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(x.convert("ABC", 1).equals("ABC"));
    }
}
