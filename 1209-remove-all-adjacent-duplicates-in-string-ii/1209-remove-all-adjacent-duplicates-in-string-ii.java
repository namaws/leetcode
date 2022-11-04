class Solution {
    public String removeDuplicates(String s, int k) {
        char[] ch = s.toCharArray();
        int[] count = new int[ch.length];
        int cntIdx = 0;
        for(int i=0; i<ch.length; i++, cntIdx++) {
            ch[cntIdx] = ch[i];
            count[cntIdx] = (cntIdx > 0 && ch[cntIdx-1] == ch[cntIdx])? count[cntIdx-1]+1:1;
            if(count[cntIdx] == k) cntIdx -= k;
        }
        return new String(ch, 0, cntIdx);
    }
}