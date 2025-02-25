import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int prevMax = 0;

        for (int[] height : heights) {
            if (height[1] < 0) {
                pq.add(-height[1]);
            } else {
                pq.remove(height[1]);
            }
            int currentMax = pq.peek();
            if (currentMax != prevMax) {
                result.add(Arrays.asList(height[0], currentMax));
                prevMax = currentMax;
            }
        }

        return result;
    }
}
