class Solution {
    public String convert(String s, int numRows) {
        /*
        numRows + (numRows-2) a loop
        */
        StringBuilder[] sbArr = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) {
            sbArr[i] = new StringBuilder();
        }
        
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            for(int idx=0; idx<numRows && i<s.length(); idx++) {
                sbArr[idx].append(s.charAt(i++));
            }
            for(int idx=numRows-2; idx>0 && i<s.length(); idx--) {
                sbArr[idx].append(s.charAt(i++));
            }
        }

        for(int j=0; j<numRows; j++) {
            sb.append(sbArr[j]);
        }
        return sb.toString();
    }
}


