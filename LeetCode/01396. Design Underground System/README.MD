# HashMap, Pair
* UndergroundSystem
	* Space Complexity: O(N)
		* N as number of stations
* checkIn
	* Time Complexity: O(1)
	* Space Complexity: O(1)
* checkOut
	* Time Complexity: O(1)
	* Space Complexity: O(1)
* getAverageTime
	* Time Complexity: O(1)
	* Space Complexity: O(1)
```
class UndergroundSystem {

    HashMap<String, Pair<Integer, Integer>> checkOutMap;//route, (totalTime, count)
    HashMap<Integer, Pair<String, Integer>> checkInMap;//id,(station, t)
    public UndergroundSystem() {
        checkOutMap = new HashMap();
        checkInMap = new HashMap();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.get(id);
        String route = checkIn.getKey() + "-" + stationName;
        int totalTime = t - checkIn.getValue();
        Pair<Integer, Integer> checkOut = checkOutMap.getOrDefault(route, new Pair<>(0,0));
        checkOutMap.put(route, new Pair<>(checkOut.getKey() + totalTime, checkOut.getValue() + 1));
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        Pair<Integer, Integer> checkout = checkOutMap.get(route);
        return (double)checkout.getKey() / checkout.getValue();
    }
}
```
```
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
```