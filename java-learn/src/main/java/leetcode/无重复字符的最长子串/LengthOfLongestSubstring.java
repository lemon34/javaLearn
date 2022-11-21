package leetcode.无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口
 */

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> stringSet = new HashSet<>();
        int left = 0;
        int right = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stringSet.contains(c)) {
                //需要移动左边的指针
                while (stringSet.contains(c)) {
                    char leftC = s.charAt(left++);
                    stringSet.remove(leftC);
                }
                stringSet.add(c);
            }else {
                //将当前元素放入set
                stringSet.add(c);
                //判断当前子串和历史已存在的子串哪个大
                length = Math.max(length, i - left + 1);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int count = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        System.out.println(count);
    }
}
