package leetcode.z字型变换;

public class ZStrConvert {

    public String convert(String s, int numRows) {
        char[][] res = new char[numRows][numRows];
        int singleLength = 2*numRows-2;
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

    public static void main(String[] args) {
        ZStrConvert zStrConvert = new ZStrConvert();
        String s = "PAYPALISHIRING";
        zStrConvert.convert(s, 3);
    }


}
