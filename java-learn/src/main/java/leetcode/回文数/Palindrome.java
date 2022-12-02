package leetcode.回文数;

public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int revertNum = 0;
        while(x > revertNum) {
            int remain = x % 10;
            revertNum = revertNum * 10 + remain;
            x /= 10;
        }
        return x == revertNum || x == revertNum /10;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        int x = 1001;
        System.out.println(palindrome.isPalindrome(x));
    }
}
