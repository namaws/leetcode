class Solution {
    public int romanToInt(String s) {
        //map for roman numeral instruction
        //<key, value> -> <symbol, value>
        Map<Character, Integer> map = new HashMap();
    
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char[] charArr = s.toCharArray();
        int ans = 0;
        for(int i=0; i<charArr.length; i++) {
            //means subtraction 
            if(i < charArr.length-1 && map.get(charArr[i]) < map.get(charArr[i+1])) {
                ans -= map.get(charArr[i]);
            }
            else {
                ans += map.get(charArr[i]);
            }
            
        }
        return ans;
    }
}