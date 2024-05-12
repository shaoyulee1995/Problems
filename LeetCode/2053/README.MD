# Kth Distinct String in an Array
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of arr
```
class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap();
        for(String a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int onceFreqNumbers = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            int freq = entry.getValue();
            if(freq == 1){
                onceFreqNumbers++;
            }
        }
        if(onceFreqNumbers < k){
            return "";
        }
        for(String a: arr){
            if(map.get(a) == 1 && --k == 0){
                return a;
            }
        }
        return "";
    }
}
```
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of arr
```
class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Boolean> map = new HashMap();
        for(String a: arr){
            if(map.containsKey(a)){
                map.put(a, false);
            }else{
                map.put(a, true);
            }
        }
        for(String a: arr){
            if(map.get(a) == true && --k == 0){
                return a;
            }
        }
        return "";
    }
}
```