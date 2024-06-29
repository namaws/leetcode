class Solution {

    public boolean isHappy(int n) {
        Set<Integer> loop = new HashSet();
        while(n!=1) {
            n = getNext(n);
            if(loop.contains(n)) return false;
            loop.add(n);
        }
        return true;
    }
    
    private int getNext(int n) {
        int sum = 0;
        while(n > 0) {
            int d = n%10;
            n = n/10;
            sum += d*d;
        }
        return sum;
    }
}