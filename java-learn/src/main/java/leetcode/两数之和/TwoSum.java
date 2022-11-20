package leetcode.两数之和;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**

     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                res[0] = i;
                res[1] = map.get(key);
                break;
            }else {
                map.put(target - key, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[] {2, 7, 11, 15};
        int[] res = twoSum.twoSum(nums, 9);
    }

}
