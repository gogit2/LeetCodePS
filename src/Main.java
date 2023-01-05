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

        /* // https://leetcode.com/problems/group-anagrams/
        String[] strs = {"a"};
        System.out.println(solution.groupAnagrams(strs));
        */

        /* // https://leetcode.com/problems/top-k-frequent-elements/
        int[]nums = {1,1,1,2,2,3};
        int k = 2;
        solution.topKFrequent(nums, k);
        */

        // https://leetcode.com/problems/product-of-array-except-self/
        int[]nums = {-1,1,0,-3,3};
        solution.productExceptSelf(nums);

    }
}