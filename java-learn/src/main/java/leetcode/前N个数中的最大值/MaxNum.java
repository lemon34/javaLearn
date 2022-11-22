package leetcode.前N个数中的最大值;

public class MaxNum {

    public int maxDP(int[] arrays , int start, int end) {
        int max = arrays[end];
        if (end == 0) {
            return max;
        }else {
            return Math.max(max, maxDP(arrays, start, end - 1));
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[] {1,3,11,6,40,7,20};
        MaxNum maxNum = new MaxNum();
        int res = maxNum.maxDP(arrays, 0, arrays.length - 1);
        System.out.println(res);
    }
}
