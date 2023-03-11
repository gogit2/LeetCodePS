import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toList;

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

    /* // https://leetcode.com/problems/two-sum/
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
    } */

    /* // https://leetcode.com/problems/group-anagrams/
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> stringListOfList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i=0; i<strs.length; i++){
            char iStrsChars[] = strs[i].toCharArray();
            Arrays.sort(iStrsChars);
            String sortedT = new String(iStrsChars);

            if (map.containsKey(sortedT)){
                map.get(sortedT).add(strs[i]);
            }else {
                map.put(sortedT, new ArrayList<>());
                map.get(sortedT).add(strs[i]);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            stringListOfList.add(entry.getValue());
        }

        return stringListOfList;
    } */

    /* // https://leetcode.com/problems/top-k-frequent-elements/
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        for (int i=0; i<k ; i++){
            result[i] = list.get(list.size()-(i+1)).getKey();
        }

        return result;
    }
    */

    /* // https://leetcode.com/problems/product-of-array-except-self/
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        int productPrefix = 1;
        int productPostfix = 1;

        for (int i=0; i<nums.length; i++){
               result[i] = productPrefix;
               productPrefix *= nums[i];
        }
        for (int j=nums.length-1; j>=0; j--){
           result[j] *= productPostfix;
           productPostfix *= nums[j];
        }

        return result;
    }
    */

    /* // https://leetcode.com/problems/valid-sudoku/description/
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> chars = new HashSet<>();
        HashSet<Character> rowChars = new HashSet<>();
        HashSet<Character> columnsChars = new HashSet<>();
        int countI = 0;

        for (int i=0; i< board.length; i++){
            for (int j=0; j< board[i].length; j++){
                if (rowChars.contains(board[i][j]))
                    return false;
                if (columnsChars.contains(board[j][i]))
                    return false;

                if (board[i][j] != '.')
                    rowChars.add(board[i][j]);
                if (board[j][i] != '.')
                    columnsChars.add(board[j][i]);

                if (i <= 2){
                    countI = 0;
                } else if (i <= 5){
                    countI = 3;
                } else if (i <= 8){
                    countI = 6;
                }

                if(i%3 == 0)  {
                    for (int k = 0; k < 3; k++) {
                        if (chars.contains(board[countI][j])) {
                            return false;
                        }
                        if (board[countI][j] != '.') {
                            chars.add(board[countI][j]);
                        }
                        countI++;
                    }

                    if (j == 2 || j == 5 || j == 8) {
                        chars.clear();
                    }
                }
            }
            rowChars.clear();
            columnsChars.clear();
        }
        return true;
    }
    */

    /* // https://leetcode.com/problems/longest-consecutive-sequence/
    public int longestConsecutive(int[] nums) {
        int longest = nums.length>0 ? 1 : 0 ;
        int maxConsecutive  = 1;
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]+1)
                maxConsecutive += 1;
            else if (nums[i] == nums[i-1])
                continue;
            else
                maxConsecutive = 1;

            if (maxConsecutive > longest) {
                longest = maxConsecutive;
            }
        }
        return longest;
    }
    */

    /* // https://leetcode.com/problems/valid-palindrome/
    public boolean isPalindrome(String s) {
//        String revercedString = "";
//        s = s.toLowerCase();
//        s = s.replaceAll("[^a-z0-9]", "");
//        char[] sChars= s.toCharArray();
//        for (int i=sChars.length-1; i>=0; i--){
//            revercedString = revercedString.concat(String.valueOf(sChars[i]));
//        }
//        return s.equals(revercedString);

        // solving it with more efficient way -> by using two pointers
        int left = 0;
        int right = s.length()-1;
        s = s.toLowerCase();
        while (left < right){
            while (!isNumeric(s.charAt(left)) ){
                if (left == s.length()-1) return true;
                else left++;
            }
            while (!isNumeric(s.charAt(right))){
                if (right == 0) return true;
                else right--;
            }
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
    private boolean isNumeric(char c){
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
    */

    /* // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public int[] twoSum(int[] numbers, int target) {
//        int[] result = new int[2];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int reqValue = 0;
//
//        for (int j=0; j<numbers.length; j++){
//            reqValue = target - numbers[j];
//            if (map.containsKey(reqValue)) {
//                result[0] = j +1;
//                result[1] = map.get(reqValue);
//                return result;
//            }
//        }
//        return result;

        // solving it with more efficient way -> by using two pointers
        int left = 0;
        int right = numbers.length-1;

        for (int i=0; i<numbers.length; i++) {
            if (numbers[left] + numbers[right] == target){
                return new int[] {left+1, right+1};
            }
            else if (numbers[left] + numbers[right] > target) {
                right--;
            }
            else if (numbers[left] + numbers[right] < target) {
                left++;
            }
        }
        return new int[]{0,0};
    }
     */

    // https://leetcode.com/problems/3sum/
    public List<List<Integer>> threeSums(int[] nums) {
        ArrayList<List<Integer>> listOfList = new ArrayList();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        int pointerLeft = 0;
        int pointerMid = 1;
        int pointerRight = nums.length-1;
        int sum = 0;

        while (pointerLeft != pointerRight){
            while (pointerMid != pointerRight) {
                sum = nums[pointerLeft] + nums[pointerMid] + nums[pointerRight];
                if (sum == 0) {
                    ArrayList the_3_sum = new ArrayList();
                    the_3_sum.add(nums[pointerLeft]);
                    the_3_sum.add(nums[pointerMid]);
                    the_3_sum.add(nums[pointerRight]);
                    set.add(the_3_sum);
                    pointerMid++;
                } else if (sum > 0){
                    pointerRight--;
                } else if (sum < 0){
                    pointerMid++;
                }
            }
            pointerLeft ++;
            pointerMid = pointerLeft+1;
            pointerRight = nums.length-1;

        }

        listOfList.addAll(set);
        return listOfList;
    }






















}
