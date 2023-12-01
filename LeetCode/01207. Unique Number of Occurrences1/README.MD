# HashMap
* Time Complexity: O(A)
* Space Complexity: O(A)
    * A as length of arr
```
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        HashSet<Integer> seen = new HashSet();
        for(int key: map.keySet()){
            if(!seen.add(map.get(key))){
                return false;
            }
        }
        return true;
    }
}
```
# Array
* Time Complexity: O(A)
* Space Complexity: O(1)
    * A as length of arr
```
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] cnt = new int[2001];
        for(int a: arr){
            cnt[a+1000]++;
        }
        boolean[] seen = new boolean[2001];
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] == 0){
                continue;
            }
            if(seen[cnt[i]]){
                return false;
            }
            seen[cnt[i]] = true;
        }
        return true;
    }
}
```