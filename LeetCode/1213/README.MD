# Intersection of Three Sorted Arrays

- Time Complexity: O(A+B+C)
- Space Complexity: O(A+B+C)
  - A as length of arr1
  - B as length of arr2
  - C as length of arr3

```
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: arr1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num: arr2){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num: arr3){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> val: map.entrySet()){
            if(val.getValue() == 3){
                res.add(val.getKey());
            }
        }
        return res;
    }
}
```

- Time Complexity: O(Max(A, B, C))
- Space Complexity: O(1)
  - A as length of arr1
  - B as length of arr2
  - C as length of arr3

```
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0,
            j = 0,
            k = 0;
        List<Integer> res = new ArrayList();
        while(i < arr1.length && j < arr2.length && k < arr3.length){
            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]){
                res.add(arr1[i]);
                i++;
                j++;
                k++;
            }else{
                if(arr1[i] < arr2[j]){
                    i++;
                }else if(arr2[j] < arr3[k]){
                    j++;
                }else{
                    k++;
                }
            }
        }
        return res;
    }
}
```
