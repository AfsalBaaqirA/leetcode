class Solution {
    public int getLucky(String s, int k) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;

            if (val >= 10) {
                res += val / 10 + val % 10;
            } else {
                res += val;
            }
        }

        while (--k > 0) {
            int temp = 0;
            while (res > 0) {
                temp += res % 10;
                res /= 10;
            }
            res = temp;
        }

        return res;
    }
}