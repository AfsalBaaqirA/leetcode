class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    fives++;
                    break;
                case 10:
                    tens++;
                    fives--;
                    break;
                case 20:
                    if (tens > 0) {
                        tens--;
                        fives--;
                    }
                    else {
                        fives -= 3;
                    }
                    break;
            }
            if (fives < 0 || tens < 0) {
                return false;
            }
        }
        return true;
    }
}