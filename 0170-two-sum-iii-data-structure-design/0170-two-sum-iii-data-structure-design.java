class TwoSum {
    List<Integer> list;
    boolean isSorted;

    public TwoSum() {
        list = new ArrayList();
        isSorted = false;
    }
    
    public void add(int number) {
        list.add(number);
        isSorted = false;
    }
    
    public boolean find(int value) {
        if(!isSorted) {
            Collections.sort(list);
            isSorted = true;
        }

        int left = 0, right = list.size()-1;
        while(left < right) {
            int curr = list.get(left)+list.get(right);
            if(curr > value) right--;
            else if(curr < value) left++;
            else return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */