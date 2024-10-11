class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        PriorityQueue<int[]> arrival = new PriorityQueue<>( (a, b) -> a[0] - b[0] );
        PriorityQueue<int[]> departure = new PriorityQueue<>( (a, b) -> a[0] - b[0] );
        for(int i=0; i<n; ++i) {
            arrival.offer(new int[] {times[i][0], i});
            departure.offer(new int[] {times[i][1], i});
        }

        PriorityQueue<Integer> available = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        int si = 0;
        while(!arrival.isEmpty()) {
            while(departure.peek()[0] > arrival.peek()[0]){
                int currFriend = arrival.poll()[1];
                if(currFriend == targetFriend) {
                    if(available.size() > 0)
                        return available.poll();

                    return si;
                }
                else {
                    if(available.size() > 0) 
                        map.put(currFriend, available.poll());
                    else 
                        map.put(currFriend, si++);
                }
            }

            while(arrival.peek()[0] >= departure.peek()[0]) {
                available.offer(map.get(departure.poll()[1]));
            }
        }

        return -1;
    }
}