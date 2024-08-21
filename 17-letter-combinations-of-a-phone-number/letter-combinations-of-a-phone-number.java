class Solution {
    private static final HashMap<Character, String> keyboard = new HashMap<>();
    private List<String> res;

    static {
        keyboard.put('2', "abc");
        keyboard.put('3', "def");
        keyboard.put('4', "ghi");
        keyboard.put('5', "jkl");
        keyboard.put('6', "mno");
        keyboard.put('7', "pqrs");
        keyboard.put('8', "tuv");
        keyboard.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        int totalCombinations = 1;
        for (char digit : digits.toCharArray()) {
            totalCombinations *= keyboard.get(digit).length();
        }

        res = new ArrayList<>(totalCombinations);
        if (digits.length() > 0) {
            backtrack(0, new StringBuilder(), digits);
        }
        return res;
    }

    private void backtrack(int i, StringBuilder curr, String digits) {
        if (curr.length() == digits.length()) {
            res.add(curr.toString());
            return;
        }
        for (char ch : keyboard.get(digits.charAt(i)).toCharArray()) {
            curr.append(ch);
            backtrack(i + 1, curr, digits);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
