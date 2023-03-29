# HashMap
* Time Complexity: O(1)
* Space Complexity: O(N)
	* N as size of map
```
class Logger {

    Map<String, Integer> map;

    public Logger() {
        map = new HashMap();    
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp+10);
            return true;
        }   
        if(map.get(message) > timestamp){
            return false;            
        }
        map.put(message, timestamp+10);
        return true;
    }
}
```