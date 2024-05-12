# Design Underground System
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
# OOP
```
class Passenger{
    String checkInStation, checkOutStation;
    int checkInTime, checkOutTime;

    public Passenger(String checkInStation, int checkInTime){
        this.checkInStation = checkInStation;
        this.checkInTime = checkInTime;
    }

    public void checkout(String checkOutStation, int checkOutTime){
        this.checkOutStation = checkOutStation;
        this.checkOutTime = checkOutTime;
    }
}

class Route{
    String startStation, endStation;
    int totalTrips;
    long totalTime;

    public Route(String startStation, String endStation){
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public double getAverage(){
        return (double)totalTime/totalTrips;
    }

    public void addTrip(int startTime, int endTime){
        this.totalTime += endTime - startTime;
        this.totalTrips++;
    }
}

class UndergroundSystem {
    
    HashMap<Integer, Passenger> passengerMap;
    HashMap<String, Route> routeMap;

    public UndergroundSystem() {
        passengerMap = new HashMap();
        routeMap = new HashMap();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if(passengerMap.containsKey(id)){
            return;
        }
        passengerMap.put(id, new Passenger(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(passengerMap.containsKey(id)){
            Passenger p = passengerMap.get(id);
            p.checkout(stationName, t);

            String routePath = p.checkInStation + "," + p.checkOutStation;
            Route route = routeMap.getOrDefault(routePath, new Route(p.checkInStation, p.checkOutStation));
            route.addTrip(p.checkInTime, p.checkOutTime);
            routeMap.put(routePath, route);
            passengerMap.remove(id);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return routeMap.get(startStation+","+endStation).getAverage();
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