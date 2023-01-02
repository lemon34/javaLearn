package leetcode.电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        if (digits.contains("1")) {
            return new ArrayList<>();
        }
        //初始化数据
        Map<Character, String> characterListMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        List<String> res = new ArrayList<>();
        bt(res, digits, characterListMap);
        return res;
    }

    private void bt(List<String> res, String digits, Map<Character, String> characterListMap) {
        if (0 == digits.length()) {
            res.add("");
            return;
        }
        //处理
        List<String> tmpStringList = new ArrayList<>();
        bt(tmpStringList, digits.substring(1), characterListMap);
        String current = characterListMap.get(digits.charAt(0));
        for (int i = 0; i < current.length(); i++) {
            for (String re : tmpStringList) {
                String tmp = current.charAt(i) + re;
                res.add(tmp);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        String s = "23";
        List<String> stringList = letterCombinations.letterCombinations(s);
        System.out.println(stringList);
    }
}
