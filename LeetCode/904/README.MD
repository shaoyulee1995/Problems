# Fruit Into Baskets

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap();
        int a = 0, ans = 0;
        for(int b = 0; b < fruits.length; b++){
            map.put(fruits[b], map.getOrDefault(fruits[b], 0) + 1);

            if(map.size() > 2){
                map.put(fruits[a], map.get(fruits[a]) - 1);
                if(map.get(fruits[a]) == 0){
                    map.remove(fruits[a]);
                }
                a++;
            }
            ans = Math.max(ans, b - a + 1);
        }
        return ans;
    }
}
```
