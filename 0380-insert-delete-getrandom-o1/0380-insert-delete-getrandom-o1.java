class RandomizedSet {
    //hashmap to store the value and the inde
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {}
    
    public boolean insert(int val) {
        if(list != null && map.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
        
    }
    
    public boolean remove(int val) {
        // if the val is in the last position
        if(map.containsKey(val)) {
            int idx = map.get(val);
            if(idx < list.size()-1) {
                int last = list.get(list.size()-1);
                map.put(last, idx);
                list.set(idx, last);
            }
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
        else {
            return false;
        }
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */