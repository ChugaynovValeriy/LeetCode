package easy;

// https://leetcode.com/problems/roman-to-integer/

public class RomanToInteger_13 {
    public int romanToInt(String s) {
        int sum = 0;
        int index = 0;
        int lastDigit = 4;
        while (index < s.length()) {
            switch (s.charAt(index)) {
                case 'I' -> {
                    sum += 1;
                    lastDigit = 1;
                }
                case 'V' -> sum += lastDigit >= 2 ? 5 : 3;
                case 'X' -> {
                    sum += lastDigit >= 2 ? 10 : 8;
                    lastDigit = Math.min(lastDigit, 2);
                }
                case 'L' -> sum += lastDigit >= 3 ? 50 : 30;
                case 'C' -> {
                    sum += lastDigit >= 3 ? 100 : 80;
                    lastDigit = Math.min(lastDigit, 3);
                }
                case 'D' -> sum += lastDigit == 4 ? 500 : 300;
                case 'M' -> sum += lastDigit == 4 ? 1000 : 800;
            }
            index++;
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger_13 x = new RomanToInteger_13();
        System.out.println(x.romanToInt("MCMXCIV"));
    }
}
