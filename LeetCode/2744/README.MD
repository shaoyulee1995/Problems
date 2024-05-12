# Find Maximum Number of String Pairs
# Array
* Time Complexity: O(NWlog(W))
* Space Complexity: O(N)
	* N as length of words
    * W as length of word
```
class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap();
        for(String word: words){
            char[] a = word.toCharArray();
            Arrays.sort(a);
            map.put(new String(a), map.getOrDefault(new String(a), 0) + 1);
        }
        int res = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() > 1){
                res += entry.getValue()/2;
            }
        }
        return res;
    }
}
```
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of words
```
class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap();
        for(String word: words){
            String a = getCharacterArray(word);  
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int res = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() > 1){
                res += entry.getValue()/2;
            }
        }
        return res;
    }

    public String getCharacterArray(String s){
        int[] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }
        return Arrays.toString(arr);
    }
}
```