class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length){
            return new int[][]{};
        }
        int[][] arr = new int[m][];

        for(int i = 0; i < m; i++){
           arr[i] = Arrays.copyOfRange(original, i * n, i * n + n);
        }
        return arr;
    }
}