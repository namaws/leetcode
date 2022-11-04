class UndergroundSystem {
    /*
    Using two map
    1. userId, {startStation, t}
    2. routeName, {totalTime, cnt}
    */
    Map<Integer, Pair<String, Integer>> checkInMap = new HashMap();
    Map<String, Pair<Double, Integer>> routeMap = new HashMap();
    
    public UndergroundSystem() {}
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.get(id);
        checkInMap.remove(id);
        
        String r = checkIn.getKey() + "_" + stationName;
        int totalTime = t - checkIn.getValue();
        Pair<Double, Integer> route = routeMap.getOrDefault(r, new Pair<>(0.0, 0));
        // if not exist in the map, route = (0.0, 0)
        // if exists -> get the real value
        routeMap.put(r, new Pair<>(route.getKey()+totalTime, route.getValue()+1));
        //totalTime adds up and the count also add up
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "_" + endStation;
        double totalTime = routeMap.get(route).getKey();
        int cnt = routeMap.get(route).getValue();
        
        return totalTime/cnt;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */