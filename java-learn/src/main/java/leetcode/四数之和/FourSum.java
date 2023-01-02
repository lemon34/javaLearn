package leetcode.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0 || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                int k = j + 1, m = nums.length - 1;
                while (k < m) {
                    int tmp = nums[i] + nums[j] + nums[k] + nums[m];
                    if (tmp > target) {
                        m--;
                        continue;
                    }
                    if (tmp < target) {
                        k ++;
                        continue;
                    }
                    if (tmp == target) {
                        List<Integer> resTmpList = new ArrayList<>();
                        resTmpList.add(nums[i]);
                        resTmpList.add(nums[j]);
                        resTmpList.add(nums[k]);
                        resTmpList.add(nums[m]);
                        res.add(resTmpList);
                        while(k < m && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        k++;
                        while(k < m && nums[m] == nums[m - 1]) {
                            m--;
                        }
                        m--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] param = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>>res = fourSum.fourSum(param, 0);
        System.out.println(res);
    }
}
