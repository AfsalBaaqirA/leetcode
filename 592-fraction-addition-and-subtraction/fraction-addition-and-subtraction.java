import java.util.regex.*;

class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;

        Pattern pattern = Pattern.compile("([+-]?\\d+)/(\\d+)");
        Matcher matcher = pattern.matcher(expression);
        
        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group(1));  // Extract numerator
            int denom = Integer.parseInt(matcher.group(2)); // Extract denominator
            
            numerator = numerator * denom + num * denominator;
            denominator *= denom;
            
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return numerator + "/" + denominator;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}