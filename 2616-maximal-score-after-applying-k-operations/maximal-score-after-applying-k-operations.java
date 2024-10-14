class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int i: nums)
            maxHeap.offer(i);

        long score = 0;
        while(--k >= 0) {
            int curr = maxHeap.poll();
            score += curr;
            maxHeap.offer((curr + 2)/3);
        }

        return score;
    }
}