class Solution {
    public void sortColors(int[] nums) {
         int low = 0; // Index for 0 
    int mid = 0; // Index for 1 
    int high = nums.length - 1; // Index for 2 
 
    while (mid <= high) { 
        if (nums[mid] == 0) { 
            swap(nums, low, mid); 
            low++; 
            mid++; 
        } else if (nums[mid] == 1) { 
            mid++; 
        } else { // nums[mid] == 2 
            swap(nums, mid, high); 
            high--; 
        } 
         } 
} 
 
private void swap(int[] nums, int i, int j) { 
    int temp = nums[i]; 
    nums[i] = nums[j]; 
    nums[j] = temp; 
} 
}
