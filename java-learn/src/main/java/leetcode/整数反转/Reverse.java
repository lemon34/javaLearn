package leetcode.整数反转;

import java.math.BigDecimal;

public class Reverse {

    /**
     * 2^31 = 2147483648
     * 反转后的范围，即-2147483648 ～ 2147483647
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE /10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            res = res * 10 + digit;
            x = x / 10;
        }
        return res;
    }



    public static void main(String[] args) {
        int x = -2147483412;
        Reverse reverse = new Reverse();
        int res = reverse.reverse(x);
        System.out.println(res);
    }
}
