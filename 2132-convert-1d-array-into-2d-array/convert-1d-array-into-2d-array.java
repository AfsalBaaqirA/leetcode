class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n == original.length) {
            int[][] resultArray = new int[m][n];
            for (int i = 0; i < original.length; i++) {
                resultArray[i / n][i % n] = original[i];
            }

            return resultArray;
        }
        return new int[][]{};
    }
}