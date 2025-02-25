import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        int maxLen = 0;

        for (int num : nums) {
            Integer lower = dp.floorKey(num - 1);
            int maxPrevLen = 0;

            while (lower != null && lower >= num - k) {
                maxPrevLen = Math.max(maxPrevLen, dp.get(lower));
                lower = dp.lowerKey(lower);
            }

            int currentLen = maxPrevLen + 1;
            dp.put(num, Math.max(dp.getOrDefault(num, 0), currentLen));
            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}
