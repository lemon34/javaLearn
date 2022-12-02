package leetcode.最长回文子串;

/**
 * 最长回文数组
 */
public class LongestPalindrome {

    /**
     * 方式一, 枚举所有状态，找出其中最长的子串
     * @param s
     * @return
     */
    public String longestPalindrome_v1(String s) {
        int res = 1;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                //初始化状态
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = 0;
            }
        }
        int begin = 0;
        //遍历子串长度
        for (int subLength = 2; subLength <= s.length(); subLength++) {
            //左边开始位置
            for (int left = 0; left < s.length(); left++) {
                //j - left + 1 = L
                int right = subLength + left - 1;
                if (right >= s.length()) {
                    continue;
                }
                if (s.charAt(left) == s.charAt(right)) {
                    if (left + 1 > right - 1) {
                        dp[left][right] = 1;
                    } else {
                        //如果相等
                        dp[left][right] = dp[left+1][right-1];
                    }
                }else {
                    //如果不相等
                    dp[left][right] = 0;
                }
                if (dp[left][right] == 1) {
                    res = Math.max(res, right - left + 1);
                    begin = left;
                }
            }
        }
        return s.substring(begin, begin + res);
    }

    public String longestPalindrome_v2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len -1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String res = longestPalindrome.longestPalindrome_v1(s);
        String res_1 = longestPalindrome.longestPalindrome_v2(s);
        System.out.println(res);
        System.out.println(res_1);
    }
}
