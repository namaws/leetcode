class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rand;
    
    public RandomizedCollection() {
        list = new ArrayList();
        map = new HashMap();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            list.add(val);
            map.get(val).add(list.size()-1);
            return false;
        }
        else {
            list.add(val);
            map.put(val, new HashSet<Integer>());
            map.get(val).add(list.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int idx = map.get(val).iterator().next();
            map.get(val).remove(idx);
            if(idx < list.size()-1) {
                int last = list.get(list.size()-1);
                list.set(idx, last);
                map.get(last).remove(list.size()-1);
                map.get(last).add(idx);
            }
            //remove val's idx
            list.remove(list.size()-1);
            if(map.get(val).isEmpty()) map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */