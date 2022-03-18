# Array
* Time Complexity: O(N*wlog(w))
* Space Complexity: O(N)
	* N as length of strs
	* w as length of w
```
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(String str: strs){
            char[] w = str.toCharArray();
            Arrays.sort(w);
            String word = new String(w);
            if(!map.containsKey(word)){
                map.put(word, new ArrayList());
            }
            map.get(word).add(str);
        }
        List<List<String>> list = new ArrayList();
        for(List<String> vals: map.values()){
            list.add(vals);
        }
        return list;
    }
}
```