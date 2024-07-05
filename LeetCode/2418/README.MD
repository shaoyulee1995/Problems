# Sort the People

- Time Complexity: O(HlogH)
- Space Complexity: O(N)
  - N as length of names
    - H as length of heights

```
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, List<String>> map = new HashMap();
        for(int i = 0; i < names.length; i++){
            map.computeIfAbsent(heights[i], x -> new ArrayList<>()).add(names[i]);
        }
        Arrays.sort(heights);
        String[] res = new String[names.length];
        for(int idx = 0, i = heights.length-1; i >= 0; i--){
            for(String name: map.get(heights[i])){
                res[idx++] = name;
            }
        }
        return res;
    }
}
```
