package leetcode.罗马数字;

public class IntToRoman {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length; i++) {

            while (num >= values[i]) {
                res.append(symbols[i]);
                num -= values[i];
            }
            if (num == 0) {
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

    }
}
