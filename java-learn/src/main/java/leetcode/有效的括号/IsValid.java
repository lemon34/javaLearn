package leetcode.有效的括号;


import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class IsValid {



    public boolean isValid(String s) {
        List<Character> leftBracket = new ArrayList<>();
//        leftBracket.add(new String("("));
        if (StringUtils.isBlank(s)) {
            return true;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (pairs.containsKey(character)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(character))) {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }
}
