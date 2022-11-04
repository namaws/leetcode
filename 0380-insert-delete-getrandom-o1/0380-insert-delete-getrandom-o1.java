class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand = new Random();
    
    public RandomizedSet() {
        list = new ArrayList();
        map = new HashMap();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        else {
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int idx = map.get(val);
            if(idx < list.size()-1) {
                int last = list.get(list.size()-1);
                map.put(last, idx);
                list.set(idx,last);
            }
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
        return false;
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