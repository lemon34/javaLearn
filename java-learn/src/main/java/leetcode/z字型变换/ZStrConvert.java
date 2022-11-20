package leetcode.z字型变换;

public class ZStrConvert {


    /**
     * 打印Z字型
     * todo 打印存在点问题
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        int singleLength = 2*numRows-2;
        char[][] res = new char[numRows][(numRows - 1) * singleLength];
        int iterCount = s.length() / singleLength + 1;
        for(int iter = 0; iter < iterCount; iter++) {
            int index = iter * singleLength;
            //第一列
            for (int j = 0; j <= (iter + 1) * (numRows -1); j++) {
                if (index >= (iter + 1)* singleLength - 1 || index >= s.length()) {
                    break;
                }
                res[j][iter*(numRows-1)] = s.charAt(index++);
            }
            for (int i = (iter + 1) * (numRows -3); i < numRows - 1; i++) {
                for (int j = (iter + 1) * (numRows -2); j >= numRows - 3; j--) {
                    if (index > (iter + 1)* singleLength - 1 || index >= s.length()) {
                        break;
                    }
                    res[j][i] = s.charAt(index++);
                }
            }
        }
        String restr = new String();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                restr = restr + res[i][j] + " ";
            }
            restr = restr + "\n";
        }
        return restr;
    }

    /**
     * 只输出字符串
     */

    public String convertStr(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int currentLineNum = 0;
        int increaseFlag = 1;
        for (int i = 0; i < s.length() ; i++) {
            stringBuilders[currentLineNum].append(s.charAt(i));
            if (currentLineNum == 0) {
                increaseFlag = 1;
            }
            if (currentLineNum == numRows -1) {
                increaseFlag = -1;
            }
            currentLineNum = currentLineNum + increaseFlag;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i ++) {
            res.append(stringBuilders[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ZStrConvert zStrConvert = new ZStrConvert();
        String s = "PAYPALISHIRING";
        String res = zStrConvert.convert(s, 3);
        System.out.println(res);
    }


}
