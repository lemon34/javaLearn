package leetcode.最接近的三数之和;

import java.util.Arrays;

public class ThreeSumClosest {


    public int threeSumClosest(int[] nums, int target) {
        //1、排序
        Arrays.sort(nums);
        int res = 0;
        int first;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            first = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int tmp = nums[j] + nums[k] + first;
                if (tmp < target ) {
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }else if (tmp > target) {
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    res = target;
                    return res;
                }
                if (Math.abs(target - tmp) < diff) {
                    diff = Math.abs(target - tmp);
                    res = tmp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] a = new int[]{0,1,2};
        int target = threeSumClosest.threeSumClosest(a, 3);
        System.out.println(target);
    }

}
