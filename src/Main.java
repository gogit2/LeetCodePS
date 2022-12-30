import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        /* // https://leetcode.com/problems/contains-duplicate/
        int[]nums = {1,2,3,4,2};
        System.out.println(solution.containsDuplicate(nums));
        */

        /* // https://leetcode.com/problems/valid-anagram/
        String name = "car";
        String noun = "rat";
        System.out.println(solution.isAnagram(name, noun));
        */

        /* // https://leetcode.com/problems/two-sum/
        int[]nums = {3,2,3};
        System.out.println(Arrays.toString(solution.twoSum(nums, 6)));
        */

        String[] strs = {"a"};
        System.out.println(solution.groupAnagrams(strs));
    }
}