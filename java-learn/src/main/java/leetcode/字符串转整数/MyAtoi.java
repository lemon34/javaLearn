package leetcode.字符串转整数;

public class MyAtoi {

    public int myAtoi(String str) {
//        char[] chars = s.toCharArray();
//        int postiveFlag = 1;
//        long res = 0;
//        for (int i = 0; i < chars.length; i++) {
//            //处理异常情况
//            char currentChar = chars[i];
//            if (currentChar == ' ') {
//                continue;
//            }
//            //判断正负号
//            if (currentChar == '-') {
//                postiveFlag = -1;
//                continue;
//            }else if (currentChar == '+'){
//                postiveFlag = 1;
//                continue;
//            }
//            if (res == 0 && (currentChar < '0' || currentChar > '9')) {
//                //如果已经计算了数值，但是下一个字符不为数字，直接返回即可
//                break;
//            } else if (Character.isDigit(currentChar)) {
//                res = postiveFlag == 1 ? Math.min((currentChar - '0') + 10 * res, Integer.MAX_VALUE) : Math.max(-(currentChar - '0') + 10 * res, Integer.MIN_VALUE);
//            }
//        }
//        return new Long(res).intValue();
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0))
                && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        int ans = 0;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            //判断溢出，或者使用long型进行存储
            int tmp = ((neg ? Integer.MIN_VALUE : Integer.MIN_VALUE + 1) + (str.charAt(i) - '0')) / 10;
            if (tmp > ans) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 - (str.charAt(i++) - '0');
        }
        return neg ? ans : -ans;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        String s = "2147483649";
        int res = myAtoi.myAtoi(s);
        System.out.println(res);
    }
}
