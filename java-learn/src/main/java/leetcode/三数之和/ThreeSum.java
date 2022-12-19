package leetcode.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - current;
//            int second = i + 1;
            for (int second = i + 1 ; second < nums.length; second++) {
                int third = nums.length - 1;
                if (second > i + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }

            }
        }
        return res;
    }
}
