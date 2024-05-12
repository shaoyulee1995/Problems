# Counting Elements
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
    * N as length of arr
```
class Solution {
    public int countElements(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for(int num: arr){
            if(map.get(num+1) != null){
                res++;
            }
        }
        return res;
    }
}
```
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
    * N as length of arr
```
class Solution {
    public int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet();
        for(int num: arr){
            set.add(num);
        }
        int res = 0;
        for(int num: arr){
            if(set.contains(num+1)){
                res++;
            }
        }
        return res;
    }
}
```