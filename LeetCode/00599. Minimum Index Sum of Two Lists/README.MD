# Matrix
* Time Complexity: O(N+M)
* Space Complexity: O(N+M)
	* N as length of list1
	* M as length of list2
```
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap();
        for(int i = 0; i < list2.length; i++){
            map.put(list2[i], i);
        }
        List<String> res = new ArrayList();
        int minSum = Integer.MAX_VALUE,
            sum;
        for(int i = 0; i < list1.length && i <= minSum; i++){
            String word = list1[i];
            Integer freq = map.get(word);
            if(freq != null){
                sum = freq + i;
                if(sum < minSum){
                    res.clear();
                    res.add(word);
                    minSum = sum;
                }else if(sum == minSum){
                    res.add(word);
                }
            }
        }       
        return res.toArray(new String[0]);
    }
}
```