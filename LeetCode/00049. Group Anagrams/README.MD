# Array
* Time Complexity: O(N*klog(k))
* Space Complexity: O(Nk)
```
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String> > ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str: strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            
            String s = String.valueOf(c);
            if(map.containsKey(s)){
                map.get(s).add(str);
            }else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(s, temp);
            }
        }
        ans.addAll(map.values());
        return ans;
    }
}
```