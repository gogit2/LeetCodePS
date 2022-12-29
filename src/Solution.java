import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // https://leetcode.com/problems/contains-duplicate/
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> items = new HashSet<>();

        for (int i=0; i<nums.length; i++) {
            if (items.contains(nums[i])){
                return true;
            }
            else
                items.add(nums[i]);
        }

        return false;
    }

}
