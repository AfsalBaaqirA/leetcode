class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        int result = 0;
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).getLast();
        for (int i = 1; i < m; i++) {
            List<Integer> array = arrays.get(i);
            result = Math.max(Math.max(result, Math.abs(maxVal - array.get(0))), 
                        Math.max(result, Math.abs(array.getLast() - minVal)));
            minVal = Math.min(minVal, array.get(0));
            maxVal = Math.max(maxVal, array.getLast());
        }
        return result;
    }
}
