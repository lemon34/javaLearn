package leetcode.括号生成;

import java.util.*;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> res = generateParenthesis.generateParenthesis(3);
        System.out.println(res);

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisAll(n, new String(), 0, 0, res);
        return res;
    }

    /**
     * @param n * 2 目标深度
     * @param res 结果
     * @param s   当前串
     */
    private void generateParenthesisAll(int n, String s, int left, int right, List<String> res) {
        if (right > left) {
            return;
        }
        if (s.length() == 2 * n) {
            if (left == right) {
                res.add(s);
            }
            return;
        }
        generateParenthesisAll(n, s + '(', left + 1, right, res);
        generateParenthesisAll(n, s + ')', left, right + 1, res);
    }


    public List<String> generateParenthesisV2(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisAllV2(n);
        return res;
    }

    private List<String> generateParenthesisAllV2(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }
        Set<String> hs = new HashSet<>();
        for (String s : generateParenthesis(n-1)) {
            for (int i = 0; i < 2*n-2; i++) {
                hs.add(s.substring(0,i) + "()" + s.substring(i,s.length()));
            }
        }
        return new ArrayList(hs);
    }
}
