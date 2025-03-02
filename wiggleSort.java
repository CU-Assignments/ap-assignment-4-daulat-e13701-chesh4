import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int n = nums.length;
        int mid = (n + 1) / 2;
        int index = 0;

        for (int i = mid - 1; i >= 0; i--) {
            nums[index] = sortedNums[i];
            index += 2;
        }

        index = 1;
        for (int i = n - 1; i >= mid; i--) {
            nums[index] = sortedNums[i];
            index += 2;
        }
    }
}
