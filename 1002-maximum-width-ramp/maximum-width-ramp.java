class Solution {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();  
        int res = 0;  
        int n = A.length;

        for (int i = 0; i < n; ++i) {

            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }

        for (int i = n - 1; i > res; --i) {

            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {

                res = Math.max(res, i - stack.peek());
                stack.pop();  
            }
        }

        return res;  
    }
}