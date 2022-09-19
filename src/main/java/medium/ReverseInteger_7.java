package medium;

// https://leetcode.com/problems/reverse-integer/

public class ReverseInteger_7 {
    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        x *= sign;
        int res = 0;
        int limit = sign * ((sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE) / 10);
        int lastDigit = sign * ((sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE) % 10);

        while (x > 0) {
            if (res > limit || res == limit && x % 10 > lastDigit) {
                return 0;
            }
            res = 10 * res + (x % 10);
            x /= 10;
        }
        return sign * res;
    }

    public static void main(String[] args) {
        ReverseInteger_7 x = new ReverseInteger_7();
        System.out.println(x.reverse(1_534_236_469));
    }
}
