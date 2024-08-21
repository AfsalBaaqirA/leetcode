class Solution {
    public int romanToInt(String s) {
        int size = s.length();
        int res = 0;
        for (int i = 1; i < size; i++){
            if(priority(s.charAt(i - 1)) >= priority(s.charAt(i)))
                res += value(s.charAt(i - 1));
            else
                res -= value(s.charAt(i - 1));
        }
        return res + value(s.charAt(size - 1));
    }
    private int priority(char i){
        switch(i){
            case 'I':
                return 0;
            case 'V':
                return 1;
            case 'X':
                return 2;
            case 'L':
                return 3;
            case 'C':
                return 4;
            case 'D':
                return 5;
        }
        return 6;
    }
    private int value(char i){
        
        switch(i){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
        }
        return 1000;
    }
}