import java.util.*;

public class Solution {

    /* // https://leetcode.com/problems/contains-duplicate/
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
    } */

    /* // https://leetcode.com/problems/valid-anagram/
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char sChars[] = s.toCharArray();
        Arrays.sort(sChars);
        String sortedS = new String(sChars);

        char tChars[] = t.toCharArray();
        Arrays.sort(tChars);
        String sortedT = new String(tChars);

        return sortedS.equals(sortedT);
    } */

    // https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0, complement=0; i<nums.length; i++){
            complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }























}
