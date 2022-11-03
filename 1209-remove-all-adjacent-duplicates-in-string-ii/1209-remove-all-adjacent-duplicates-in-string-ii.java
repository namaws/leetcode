class Solution {
    public String removeDuplicates(String s, int k) {
        char[] ch = s.toCharArray();
        
        //inplace => two pointer
        int[] count = new int[ch.length];
        int l = 0;
        for(int r=0; r<s.length(); l++, r++) {
            ch[l] = ch[r]; // right is the current input -> replace left element, if needed
            count[l] = (l>0 && ch[l-1] == ch[l]) ? count[l-1]+1: 1;
            if(count[l] == k) l-=k;
        }
        return new String(ch, 0, l);
    }
}