class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m > n) return false;  

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= n - m; i++) {

            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }

            if (i + m < n) {

                windowFreq[s2.charAt(i) - 'a']--;

                windowFreq[s2.charAt(i + m) - 'a']++;
            }
        }

        return Arrays.equals(s1Freq, windowFreq);
    }
}