class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;
            sb.append(String.valueOf(val));
        }
        s = sb.toString();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += s.charAt(i) - '0';
        }
        while (k > 1) {
            String tmp = String.valueOf(res);
            int temp = 0;
            for (int i = 0; i < tmp.length(); i++) {
                temp += tmp.charAt(i) - '0';
            }
            res = temp;
            k--;
        }
        return res;
    }
}