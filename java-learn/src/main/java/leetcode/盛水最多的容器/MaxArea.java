package leetcode.盛水最多的容器;

public class MaxArea {

    public int maxArea(int[] height) {
        int res = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            res = Math.max(res, ((j - i) * Math.min(height[i], height[j])));
            if (height[i] < height[j]) {
                i++;
            }else if (height[i] >= height[j]) {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int res = maxArea.maxArea(height);
        System.out.println(res);
    }
}
