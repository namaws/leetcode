class Solution {
    private List<String> combinations = new ArrayList();
    private Map<Character, String> map = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    private String digits;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 ) return combinations;
        this.digits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int idx, StringBuilder sb) {
        if(sb.length() == digits.length()) {
            combinations.add(sb.toString());
            return;
        }        
        String str = map.get(digits.charAt(idx));
        for(char c: str.toCharArray()) {
            sb.append(c);
            backtrack(idx+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}